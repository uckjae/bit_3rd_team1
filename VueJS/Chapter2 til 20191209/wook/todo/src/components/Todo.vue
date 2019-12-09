<template>
    <button type="button" class="list-group-item text-left" @click="toggleTodoState(todo)" >
        {{label}}
    </button>
</template>

<script>
    export default {
        props:['label'],
        methods:{
            clickButton(){
                this.$emit('componentClick');
            }
        }
    }
</script>

<style scoped>

</style>