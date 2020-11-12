<template id="parking-create" @parking-submitted="createParking">
    <div>
        <header>
            <h1>Parking App</h1>
        </header>
        <nav id="normalNav">
            <a href="/parking-spot">Home</a>
            <a href="/account/6648dfdc-9733-4a34-bfa0-e9de8c1ca78b/my-parking-spots">My Parking spots</a>
            <a id="lastLink" href="/">Logout</a>
        </nav>
        <div class="form-style">
            <h2>Create new parking spot</h2>
            <form class="create" @submit="checkForm" :action=`/api/user/${ownerId}/createParking` method="post">
                <div v-if="errors.length">
                    <b>Please correct the following error(s):</b>
                    <ul>
                        <li v-for="error in errors">{{ error }}</li>
                    </ul>
                </div>
                <p>
                    <label for="name">Type<label>
                    <input type="text" name="type" id="type" v-model="type">
                </p>
                <p>
                    <label for="name">Available<label>
                    <input type="text" name="available" id="available" v-model="available">
                </p>
                <p>
                    <label for="name">Width<label>
                    <input type="text" name="width" id="width" v-model="width">
                </p>
                <p>
                    <label for="name">Height<label>
                    <input type="text" name="height" id="height" v-model="height">
                </p>
                <p>
                    <label for="name">Postal code<label>
                    <input type="text" name="postalCode" id="postalCode" v-model="postalCode">
                </p>
                <p>
                    <label for="name">Street address<label>
                    <input type="text" name="streetAddress" id="streetAddress" v-model="streetAddress">
                </p>
                <p>
                    <label for="name">Street number<label>
                    <input type="text" name="streetNumber" id="streetNumber" v-model="streetNumber">
                </p>
                <p>
                    <input type="submit" value="Create Child">
                </p>

            </form>
        </div>
    </div>

</template>
<script>
    Vue.component("parking-create", {
        template: "#parking-create",
        data: () => ({
            ownerId: null,
            type: null,
            available: null,
            width: null,
            height: null,
            postalCode: null,
            streetAddress: null,
            streetNumber: null,
            pictureURL: null,
            errors: []
        }),
        created() {
            fetch(`/api/user/${ownerId}`)
                .then(res => res.json())
                .then(res => {
                    this.ownerId = res.accountId
                })
                .catch(() => alert("User not found"))
        },
        methods:{
            checkForm:function(e) {
                const urlRegex = "/^(?:(?:(?:https?|ftp):)?\\/\\/)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\\.(?:[a-z\u00a1-\uffff]{2,})))(?::\\d{2,5})?(?:[/?#]\\S*)?$/i";
                if(this.Type && this.available && this.width && this.height && this.postalCode && this.streetAddress && this.streetNumber) return true;
                this.errors = [];
                if (!this.type) this.errors.push("Type required");
                if (!this.available) this.errors.push("Available required");
                if (!this.width) this.errors.push("Width required");
                if (!this.height) this.errors.push("Height required");
                if (!this.postalCode) this.errors.push("Postal code required");
                if (!this.streetAddress) this.errors.push("Street address required");
                if (!this.streetNumber) this.errors.push("Street number required");
                e.preventDefault();
            }
        }
    });
</script>
<style>
    .form-style{
        font-family: 'Open Sans Condensed', arial, sans;
        width: 500px;
        padding: 30px;
        background: #191919;
        margin: 50px auto;
        box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
        -moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
        -webkit-box-shadow:  0px 0px 15px rgba(0, 0, 0, 0.22);
        border: #dddddd;
    }
    .form-style h2{
        background: #4D4D4D;
        text-transform: uppercase;
        font-family: 'Open Sans Condensed', sans-serif;
        color: #FFFFFF;
        font-size: 18px;
        font-weight: 100;
        padding: 20px;
        margin: -30px -30px 30px -30px;
    }
    .form-style input[type="text"],
    .form-style input[type="date"],
    .form-style input[type="datetime"],
    .form-style input[type="email"],
    .form-style input[type="number"],
    .form-style input[type="search"],
    .form-style input[type="time"],
    .form-style input[type="url"],
    .form-style input[type="password"],
    .form-style textarea,
    .form-style select
    {
        box-sizing: border-box;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        outline: none;
        display: block;
        width: 100%;
        padding: 7px;
        border: none;
        color: white;
        border-bottom: 1px solid #ddd;
        background: transparent;
        margin-bottom: 10px;
        font: 16px Arial, Helvetica, sans-serif;
        height: 45px;
    }
    .form-style textarea{
        resize:none;
        overflow: hidden;
    }
    .form-style input[type="button"],
    .form-style input[type="submit"]{
        background: none;
        display: inline-block;
        cursor: pointer;
        font-family: 'Open Sans Condensed', sans-serif;
        font-size: 14px;
        text-decoration: none;
        text-transform: uppercase;
        padding: 10px;
        margin: 10px;
        border: 1px solid white;
        color: white;
        border-radius: 15px;
    }
    .form-style input[type="button"]:hover,
    .form-style input[type="submit"]:hover {
        border: 2px solid white;
    }

    .create {
        color: white;
    }
</style>