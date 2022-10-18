<template>
  <div />
</template>

<script>

import {GridView, LocalDataProvider} from 'realgrid';



export default {
  name: "Grid",
  data(){
    return{

      currentPage: 1,
    }
  },
  mounted() {

    const provider = new LocalDataProvider(false);


  }
}
</script>

<style scoped>

</style>
