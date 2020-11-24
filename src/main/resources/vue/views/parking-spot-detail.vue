<template id="parking-spot-detail">
    <div class="content-wrapper">
        <header>
            <h1>EZpark</h1>
        </header>
        <nav id="normalNav">
            <a href="/parking-spot">Home</a>
            <a href="/account/6648dfdc-9733-4a34-bfa0-e9de8c1ca78b/my-parking-spots">My Parking spots</a>
            <a id="lastLink" href="/">Logout</a>
        </nav>
        <div v-if="parkingSpot" class="detail-parking-spot-container">
            <div id="imgDiv">
                <img v-if="parkingSpot.pictureURL" class="cover-image" v-bind:src="parkingSpot.pictureURL">
                <img v-else class="cover-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
            </div>
            <div id="txtDiv">
                <h1 id="street">{{ parkingSpot.streetAddress }}  {{parkingSpot.streetNumber}}</h1>
                <h1 id="city">{{ parkingSpot.postalCode }}  {{parkingSpot.city}}</h1>
                <h1 id="width">Width: {{ parkingSpot.width }}cm</h1>
                <h1 id="length">Length: {{ parkingSpot.length }}cm</h1>
                <h1 id="height">Height: {{ parkingSpot.height }}cm</h1>
                <h1>Owner: {{ owner.displayName }}</h3>
                <div id="orderButton" >
                    <a :href="`/parking-spot/${parkingSpot.parkingSpotId}/payment`" class="link-to-parking-spot-detail">
                        <h1>Rent parking spot</h1>
                    </a>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    Vue.component("parking-spot-detail", {
        template: "#parking-spot-detail",
        data: () => ({
            parkingSpot: null,
            owner: null,
        }),
        created() {
            const parkingSpotId = this.$javalin.pathParams["parking-spot-id"];

            fetch(`/api/parking-spot/${parkingSpotId}`)
                .then(res => res.json())
                .then(res => {
                    this.parkingSpot = res;

                    let owner = this.parkingSpot.ownerId
                    fetch(`/api/account/${owner}`)
                        .then(res => res.json())
                        .then(res => this.owner = res)
                        .catch(() => alert("Error while fetching owner"));
                }).catch(() => alert("Error while fetching parking spot"));
        }
    });
</script>
<style>

    #orderButton h1{
    padding-bottom: 10px;
        background-color: #434346;
    }

    #txtDiv {
        width: 35%;
    }

    #imgDiv {
        width: 300px;
        height: 300px;
    }

    .detail-parking-spot-container {
        color: black;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;
    }

    #sortList {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        margin-top: 30px;
        margin-bottom: 30px;
    }

    #sortList li {
        padding: 10px;
        margin: 10px;
        border: 1px solid white;
        color: white;
        border-radius: 15px;
    }

    #sortList li a {
        color: white;
        text-decoration: none;
        font-weight: bold;
    }


    #sortList li:hover {
        border: 2px solid white;
    }

    #parkingName {

    }

    div.detail-parking-spot-container {
        padding: 10px;
        overflow: hidden;
        width: 750px;
        margin: 0 auto;
        background-color: rgba(20, 20, 20, 0.98);
        opacity: 0.96;
        color: white;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0, 0, 0, 0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0, 0, 0, 0.25);
        box-shadow: 10px 10px 5px 0px rgba(0, 0, 0, 0.25);
    }

    div.single-planet-container {
        overflow: hidden;
        color: white;
        background-color: rgba(0, 0, 0, 0.98);
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
    }

    .single-star-container {
        height: 100px;
        width: 40%;
        background-color: #F0FFFF;
        opacity: 0.96;
        text-align: center;
        margin-left: 34%;
    }


    div.single-star-container:hover {
        height: 115px;
        opacity: 1.0;
    }

    img.cover-image {
        height: auto;
        width: 100%;
        margin: 5px;
    }

    img.list-image {
        width: 140px;
        padding-bottom: 20px;
        transition: transform .2s;
    }

    .list-image:hover {
        transform: scale(1.1);
    }

    h1 {
        font-size: 18px;
        padding-top: 10px;
    }

    .link-to-planet-details {
        width: 400px;
        height: 100px;
        text-decoration: none;
        color: black;
    }

    .button {
        padding: 10px;
        margin: 10px;
        border: 1px solid white;
        color: white;
        border-radius: 15px;
    }

    button a {
        color: white;
        text-decoration: none;
        font-weight: bold;
    }

    .button:hover {
        border: 2px solid white;
    }
</style>