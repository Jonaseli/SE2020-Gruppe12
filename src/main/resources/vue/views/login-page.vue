<template id ="login">
    <div>
        <header>
            <h1>Login Page</h1>
        </header>
        <main>
            <button id="userBtn" v-on:click="redirect" class="center">Login as User</button>
        </main>
    </div>
</template>
<script>
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