<template id="payment-page">
    <div>
        <header>
            <h1>EZpark</h1>
        </header>
        <nav id="normalNav">
            <a href="/parking-spot">Home</a>
            <a href="/account/6648dfdc-9733-4a34-bfa0-e9de8c1ca78b/my-parking-spots">My Parking spots</a>
            <a id="lastLink" href="/">Logout</a>
        </nav>
        <div class="form-style" v-if="parkingSpot">
            <h2>Create new reservation for {{ parkingSpot.width }}</h2>
            <div id="tester">
                <div class="rentButton" id="Success">
                    <a :href="`/api/parking-spot/${parkingSpot.parkingSpotId}/payment`" class="link-to-parking-spot-detail">
                    <h1>Successful payment</h1>
                    </a>
                </div>
                <div class="rentButton" id="failed">
                    <a :href="`/parking-spot/${parkingSpot.parkingSpotId}/payment`" class="link-to-parking-spot-detail" v-on:click="failedPayment">
                    <h1>Failed payment</h1>
                    </a>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    Vue.component("payment-page", {
        template: "#payment-page",
        data: () => ({
            parkingSpot: null,
            errors: []
        }),
        created() {
            const idee = this.$javalin.pathParams["parking-spot-id"];
            fetch(`/api/parking-spot/${idee}`)
                .then(res => res.json())
                .then(res => this.parkingSpot = res)
                .catch(() => alert("Error finding parking spot"))

        },  methods: {
              failedPayment: function (event) {
                  alert("Payment failed (This is a stub)")
              }
            },
    });
</script>
<style>

    #tester {
        display: flex;
        flex-direction: row;
        justify-content: center;
    }

    div.rentButton {
        margin-left: 10px;
        background-color: red;

    }

    div.rentButton a{
        overflow: hidden;
        display: block;
        width: 200px;
        height: 50px;
    }

    div.rentButton h1{
        padding: 0px;
    }

    div.rentButton#success {
        background-color: #075712;
    }

    div.rentButton#success:hover {
        background-color: #0e7a1d;
    }

    div.rentButton#failed {
        background-color: #5a0606f5;
    }

    div.rentButton#failed:hover {
        background-color: #7b0606f5;
    }

    .form-style {
        font-family: 'Open Sans Condensed', arial, sans;
        width: 500px;
        padding: 30px;
        background: #191919;
        margin: 50px auto;
        box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
        -moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
        -webkit-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
        border: #dddddd;
    }

    .form-style h2 {
        background: #4D4D4D;
        text-transform: uppercase;
        font-family: 'Open Sans Condensed', sans-serif;
        color: #FFFFFF;
        font-size: 18px;
        font-weight: 100;
        padding: 20px;
        margin: -30px -30px 30px -30px;
    }

    .form-style textarea {
        resize: none;
        overflow: hidden;
    }
</style>