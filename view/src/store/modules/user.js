import { getInfo, login, logout } from '@/api/user'
import { getToken, removeToken, setToken } from '@/utils/auth'
import router, { resetRouter } from '@/router'

const state = {
  token: '',
  userId: '',
  name: '',
  roleName: '',
  status: '',
  avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
  permissionList: []
}

const mutations = {
  SET_TOKEN: (state, token) => {
    state.token = token
    setToken(token)
  },
  SET_USER: (state, user) => {
    state.userId = user.id
    state.name = user.name
    state.roleName = user.role
    state.status = user.status
    if (user.role === 'admin') {
      state.permissionList = ['admin', 'user']
    } else {
      user.role.split(',').forEach(p => {
        state.permissionList.push(p)
      })
    }
  },
  RESET_USER: (state) => {
    state.token = ''
    state.userId = -1
    state.name = ''
    state.roleName = ''
    state.status = ''
    state.permissionList = []
  }
}

const actions = {
  // user login
  login({ commit }, loginInfo) {
    const { username, password } = loginInfo
    return new Promise((resolve, reject) => {
      login({ name: username.trim(), password: password }).then(response => {
        commit('SET_TOKEN', response.data.data)
        resolve(response.data.data)
      }).catch(error => {
        reject(error)
      })
    })
  },

  // get user info
  getInfo({ commit }) {
    return new Promise((resolve, reject) => {
      getInfo(getToken()).then(response => {
        if (!response) {
          reject('Verification failed, please Login again.')
        }
        commit('SET_USER', response.data.data)
        resolve(response.data.data)
      }).catch(error => {
        reject(error)
      })
    })
  },

  // user logout
  logout({ commit }) {
    return new Promise((resolve, reject) => {
      logout().then(() => {
        commit('RESET_USER')
        removeToken()
        resetRouter()
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // dynamically modify permissions
  async changeRoles({ commit, dispatch }, role) {
    const token = role + '-token'

    commit('SET_TOKEN', token)
    setToken(token)

    const { roles } = await dispatch('getInfo')

    resetRouter()

    // generate accessible routes map based on roles
    const accessRoutes = await dispatch('permission/generateRoutes', roles, { root: true })
    // dynamically add accessible routes
    router.addRoutes(accessRoutes)

    // reset visited views and cached views
    dispatch('tagsView/delAllViews', null, { root: true })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
