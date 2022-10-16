<template>
<div class="board-detail">

  <div class="board-contents">
    <h3>{{ title }}</h3>
    <div>
      <span>{{ created_at }}</span>
    </div>
    <div class="board-contents">
    <span>{{contents}}</span>
    </div>
  </div>
</div>
</template>

<script>
export default {
  name: "Detail.vue"
}
</script>

<style scoped>

</style>
