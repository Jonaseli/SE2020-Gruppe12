<template id="login-buttons">
    <div>
        <header>
            <h1>Login Page</h1>
        </header>
        <main>
            <div class="login-button">
                <a href="/parking-spot">Login as User</a>
            </div>
            <div class="login-button">
                <a href="/parking-spot">Login as Corporation</a>
            </div>
            <div class="login-button">
                <a href="/admin-page">Login as Admin</a>
            </div>
        </main>
    </div>
</template>
<script>
    Vue.component("login-page", {template: "#login-buttons"});
</script>
<style>
    div.login-button {
        display: flex;
        background-color: black;
        margin: auto;
        margin-bottom: 20px;
        width: 200px;
        height: 50px;
        justify-content: center;
        align-items: center;
        line-height: 50px;
    }

    div.login-button a {
        flex-grow: 1;
        display: block;
        height: 50px;
        color: white;
        text-decoration: none;
        vertical-align: text-bottom;
    }


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