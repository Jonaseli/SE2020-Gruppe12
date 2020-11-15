<template id ="login">
    <div>
        <header>
            <h1>Login Page</h1>
        </header>
        <main>
            <button id="userBtn" v-on:click="redirect" class="center">Login as User</button>
            <button id="corpBtn" v-on:click="redirect" class="center">Login as Corporation</button>
            <button id="adminBtn" v-on:click="redirect" class="center">Login as Admin</button>
        </main>
    </div>
</template>
<script>
    //import Vue from 'vue'
    //window.Vue = require('vue');
    console.log(window);
    Vue.component("login-page",{
        template : "#login",
        methods: {
            redirect: function (event) {
                window.location.href = 'parking-spot';
            }
        }});
</script>
<style>
    header {
        text-align: center;
    }

    main {
        text-align: center;
    }

    main, button {
        height: 50px;
    }
</style>