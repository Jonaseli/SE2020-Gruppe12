<template id ="login">
    <div>
        <header>
            <h1>Login Page</h1>
        </header>
        <main>
            <button id="userBttn" class="center">Logg in as User</button>
        </main>
    </div>
</template>
<script>
    Vue.component("login-page",
        {   template : "#login"
        })

    window.onload = startup;
    function startup(){
        var bttn = document.getElementById("userBttn");
        bttn.addEventListener("click", function () {
                console.log("clicked");
        });
    }
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