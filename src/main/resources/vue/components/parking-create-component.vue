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
                <div>
                <p>Types</p>
                <p>
                    <label for="name"><label>
                    <input type="checkbox" name="type" id="type" v-model="type"><span class="label"></span>
                </p>
                </div>
                <div class="sameLine3Input">
                    <p>
                        <label for="name">Width (cm)<label>
                        <input type="number" name="width" id="width" v-model="width" placeholder="0" min="0" max="999">
                    </p>
                   <p>
                        <label for="name">Length (cm)<label>
                        <input type="number" name="length" id="length" v-model="length" placeholder="0" min="0" max="999">
                    </p>
                    <p>
                        <label for="name">Height (cm)<label>
                        <input type="number" name="height" id="height" v-model="height" placeholder="0" min="0" max="999">
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

    input[type=checkbox] {
      display: none;
    }
    .label {
      border: 1px solid #000;
      display: inline-block;
      padding: 3px;
      background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE4LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQ5MS45NzUgNDkxLjk3NSIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDkxLjk3NSA0OTEuOTc1OyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8ZyBpZD0iWE1MSURfMjhfIj4NCgk8cGF0aCBpZD0iWE1MSURfMzFfIiBkPSJNMjI1LjMxNSw5Ni45NjNjMjYuNzQ4LDAsNDguNDc5LTIxLjcwNiw0OC40NzktNDguNDgxQzI3My43OTQsMjEuNjk5LDI1Mi4wNjMsMCwyMjUuMzE1LDANCgkJYy0yNi43NzksMC00OC40OTIsMjEuNjk5LTQ4LjQ5Miw0OC40ODJDMTc2LjgyMyw3NS4yNTcsMTk4LjUzNiw5Ni45NjMsMjI1LjMxNSw5Ni45NjN6Ii8+DQoJPHBhdGggaWQ9IlhNTElEXzMwXyIgZD0iTTMwMC4yMzMsMzcxLjY4OGMtMTIuODgzLDQ0LjczMi01NC4xMjEsNzcuNTgzLTEwMi45NDYsNzcuNTgzYy01OS4xMjYsMC0xMDcuMjA5LTQ4LjA4NS0xMDcuMjA5LTEwNy4xOTMNCgkJYzAtNDMuNzU0LDI2LjM5Ni04MS40MTMsNjQuMDY2LTk4LjA1NFYxOTguNThjLTYxLjY5LDE4LjU4MS0xMDYuNzY0LDc1Ljg0Ny0xMDYuNzY0LDE0My40OTgNCgkJYzAsODIuNjQ5LDY3LjI0NywxNDkuODk3LDE0OS45MDYsMTQ5Ljg5N2M2MC4yMzgsMCwxMTIuMTU5LTM1LjgwMSwxMzUuOTY2LTg3LjE2OWwtMTYuOTI2LTMzLjI1NQ0KCQlDMzExLjU3NSwzNzEuNTksMzA2LjA3MSwzNzEuNjQsMzAwLjIzMywzNzEuNjg4eiIvPg0KCTxwYXRoIGlkPSJYTUxJRF8yOV8iIGQ9Ik00NDEuNDgsNDI5LjIzN2wtNjQuOTM5LTEyNy42NzJjLTQuODQ3LTkuNTUzLTE0LjY0NS0xNS41NjYtMjUuMzYzLTE1LjU2NmgtODMuMTczdi0xOC45NjZoNzEuNTgyDQoJCWM3LjE0OCwwLDEzLjE1Ni0zLjczNiwxNy4wMzctOS4xMThjMi41MjItMy41MDYsNC4zMTYtNy41NzksNC4zMTYtMTIuMjM2YzAtMTEuNzg5LTkuNTQ5LTIxLjM1MS0yMS4zNTMtMjEuMzUxaC00My4xMjVoLTI4LjQ1Nw0KCQlWMTYwYzAtMTcuNjkyLTEzLjExOC00Mi43MDQtNDIuNjg5LTQyLjcwNGMtMjMuNTg0LDAtNDIuNzAzLDE5LjEyMi00Mi43MDMsNDIuNzA0djEzOS4zNzJjMCwyNC4wNTgsMTkuNTAzLDQzLjU2MSw0My41NjIsNDMuNTYxDQoJCWg3OC4yNjVoMjkuMjg0bDU3LjAyNCwxMTIuMTE3YzUuMDExLDkuODc1LDE1LjAxMSwxNS41NzMsMjUuMzg5LDE1LjU3M2M0LjM1LDAsOC43NjEtMC45OTQsMTIuODgzLTMuMTA0DQoJCUM0NDMuMDU0LDQ2MC40MDEsNDQ4LjYyOCw0NDMuMjUxLDQ0MS40OCw0MjkuMjM3eiIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=) no-repeat left center;
      width: 25px;
      height: 25px;
    }
    input[type=checkbox]:checked + .label {
      background: green;
      color: white;
      background-image: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE4LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQ5MS45NzUgNDkxLjk3NSIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDkxLjk3NSA0OTEuOTc1OyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8ZyBpZD0iWE1MSURfMjhfIj4NCgk8cGF0aCBpZD0iWE1MSURfMzFfIiBkPSJNMjI1LjMxNSw5Ni45NjNjMjYuNzQ4LDAsNDguNDc5LTIxLjcwNiw0OC40NzktNDguNDgxQzI3My43OTQsMjEuNjk5LDI1Mi4wNjMsMCwyMjUuMzE1LDANCgkJYy0yNi43NzksMC00OC40OTIsMjEuNjk5LTQ4LjQ5Miw0OC40ODJDMTc2LjgyMyw3NS4yNTcsMTk4LjUzNiw5Ni45NjMsMjI1LjMxNSw5Ni45NjN6Ii8+DQoJPHBhdGggaWQ9IlhNTElEXzMwXyIgZD0iTTMwMC4yMzMsMzcxLjY4OGMtMTIuODgzLDQ0LjczMi01NC4xMjEsNzcuNTgzLTEwMi45NDYsNzcuNTgzYy01OS4xMjYsMC0xMDcuMjA5LTQ4LjA4NS0xMDcuMjA5LTEwNy4xOTMNCgkJYzAtNDMuNzU0LDI2LjM5Ni04MS40MTMsNjQuMDY2LTk4LjA1NFYxOTguNThjLTYxLjY5LDE4LjU4MS0xMDYuNzY0LDc1Ljg0Ny0xMDYuNzY0LDE0My40OTgNCgkJYzAsODIuNjQ5LDY3LjI0NywxNDkuODk3LDE0OS45MDYsMTQ5Ljg5N2M2MC4yMzgsMCwxMTIuMTU5LTM1LjgwMSwxMzUuOTY2LTg3LjE2OWwtMTYuOTI2LTMzLjI1NQ0KCQlDMzExLjU3NSwzNzEuNTksMzA2LjA3MSwzNzEuNjQsMzAwLjIzMywzNzEuNjg4eiIvPg0KCTxwYXRoIGlkPSJYTUxJRF8yOV8iIGQ9Ik00NDEuNDgsNDI5LjIzN2wtNjQuOTM5LTEyNy42NzJjLTQuODQ3LTkuNTUzLTE0LjY0NS0xNS41NjYtMjUuMzYzLTE1LjU2NmgtODMuMTczdi0xOC45NjZoNzEuNTgyDQoJCWM3LjE0OCwwLDEzLjE1Ni0zLjczNiwxNy4wMzctOS4xMThjMi41MjItMy41MDYsNC4zMTYtNy41NzksNC4zMTYtMTIuMjM2YzAtMTEuNzg5LTkuNTQ5LTIxLjM1MS0yMS4zNTMtMjEuMzUxaC00My4xMjVoLTI4LjQ1Nw0KCQlWMTYwYzAtMTcuNjkyLTEzLjExOC00Mi43MDQtNDIuNjg5LTQyLjcwNGMtMjMuNTg0LDAtNDIuNzAzLDE5LjEyMi00Mi43MDMsNDIuNzA0djEzOS4zNzJjMCwyNC4wNTgsMTkuNTAzLDQzLjU2MSw0My41NjIsNDMuNTYxDQoJCWg3OC4yNjVoMjkuMjg0bDU3LjAyNCwxMTIuMTE3YzUuMDExLDkuODc1LDE1LjAxMSwxNS41NzMsMjUuMzg5LDE1LjU3M2M0LjM1LDAsOC43NjEtMC45OTQsMTIuODgzLTMuMTA0DQoJCUM0NDMuMDU0LDQ2MC40MDEsNDQ4LjYyOCw0NDMuMjUxLDQ0MS40OCw0MjkuMjM3eiIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=);
    }


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