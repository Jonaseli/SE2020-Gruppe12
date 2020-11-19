<template id="parking-create" @parking-submitted="createParking">
    <div>
        <header>
            <h1>EZpark</h1>
        </header>
        <nav id="normalNav">
            <a href="/parking-spot">Home</a>
            <a href="/account/6648dfdc-9733-4a34-bfa0-e9de8c1ca78b/my-parking-spots">My Parking spots</a>
            <a id="lastLink" href="/">Logout</a>
        </nav>
        <div class="form-style">
            <h2>Create new parking spot</h2>
            <form class="create" @submit="checkForm" :action=`/api/account/${accountId}/my-parking-spots/create-parking` method="post">
                <div v-if="errors.length">
                    <b>Please correct the following error(s):</b>
                    <ul>
                        <li v-for="error in errors">{{ error }}</li>
                    </ul>
                </div>
                <div class="sameLineInput">
                    <p>
                        <label for="name">Street address<label>
                        <input type="text" name="streetAddress" id="streetAddress" v-model="streetAddress" placeholder="street address">
                    </p>
                    <p>
                        <label for="name">Street number<label>
                        <input type="text" name="streetNumber" id="streetNumber" v-model="streetNumber" placeholder="street number">
                    </p>
                </div>
                <div class="sameLineInput">
                    <p>
                        <label for="name">Postal code<label>
                        <input type="text" name="postalCode" id="postalCode" v-model="postalCode" placeholder="postal code">
                    </p>
                    <p>
                        <label for="name">Poststed<label>
                        <input type="text" name="poststed" id="poststed" v-model="poststed" placeholder="poststed">
                    </p>
                </div>
                <p>
                    <label for="name">Type<label>
                    <input type="text" name="type" id="type" v-model="type" placeholder="Type of parking spot e.g Handicap">
                </p>
                <div class="sameLine3Input">
                    <p>
                        <label for="name">Width (cm)<label>
                        <input type="number" name="width" id="width" v-model="width" placeholder="0">
                    </p>
                   <p>
                        <label for="name">Length (cm)<label>
                        <input type="number" name="length" id="length" v-model="length" placeholder="0">
                    </p>
                    <p>
                        <label for="name">Height (cm)<label>
                        <input type="number" name="height" id="height" v-model="height" placeholder="0">
                    </p>
                </div>
                <p>
                    <input type="submit" value="Create Parking">
                </p>
            </form>
        </div>
    </div>

</template>
<script>
</script>
<style>

    .sameLineInput {
        margin: auto;
    }

    .sameLineInput p{
        float:left;
        margin: 10px;
        padding: 10px;
    }

    .sameLine3Input {
        margin: auto;
    }

    .sameLine3Input p{
        float:left;
        margin: 10px;
        padding: 10px;
        width: 126px;
    }


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