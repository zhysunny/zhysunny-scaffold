<template>
  <div class="app-container">
    <aside>
      {{ message }}
    </aside>
  </div>
</template>

<script>
import { hello } from '@/api/hello.js'

export default {
  name: 'Hello',
  data() {
    return {
      message: ''
    }
  },
  created() {
    this.hello()
  },
  methods: {
    hello() {
      hello().then((response) => {
        this.message = response.data
        this.$message.success('success')
      }).catch(() => {
        this.$message.error('failed')
      })
    }
  }
}
</script>
