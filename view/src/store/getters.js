const getters = {
  sidebar: state => state.app.sidebar,
  size: state => state.app.size,
  device: state => state.app.device,
  visitedViews: state => state.tagsView.visitedViews,
  cachedViews: state => state.tagsView.cachedViews,
  token: state => state.user.token,
  userId: state => state.user.userId,
  name: state => state.user.name,
  roleName: state => state.user.roleName,
  avatar: state => state.user.avatar,
  status: state => state.user.status,
  permissionList: state => state.user.permissionList,
  permission_routes: state => state.permission.routes,
  errorLogs: state => state.errorLog.logs
}
export default getters
