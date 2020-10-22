<template id ="login">
    <div>
        <h1>Login Page</h1>
        <button id="userBttn">Logg in as User</button>
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
</style>