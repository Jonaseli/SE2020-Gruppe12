<template id="my-parking-spots">
   <div>
        <header>
            <h1>EZpark</h1>
        </header>
        <nav id="normalNav">
            <a href="/parking-spot">Home</a>
            <a href="/account/6648dfdc-9733-4a34-bfa0-e9de8c1ca78b/my-parking-spots">My Parking spots</a>
            <a id="lastLink" href="/">Logout</a>
        </nav>
        <ul class="parking-spots-overview-list">
            <li>
                <a :href="`/account/${account}/my-parking-spots/create-parking`" class="link-to-parking-spot-detail">
                    <div class="single-parking-spot-container" >
                        <h1>Create new parking spot</h1>
                    </div>
                </a>
            </li>
        </ul>
        <h1>Owned parking spots</h1>
        <ul class="parking-spots-overview-list">
            <li v-for="parkingSpot in ownedParkingSpots">
                <a :href="`/parking-spot/${parkingSpot.parkingSpotId}`" class="link-to-parking-spot-detail">
                    <div class="single-parking-spot-container" >
                        <h1>{{parkingSpot.available}} - {{parkingSpot.streetAddress}}</h1>
                        <h1>{{parkingSpot.ownerId}}</h1>
                    </div>
                </a>
            </li>
        </ul>
        <h1>Rented parking spots</h1>
        <ul class="parking-spots-overview-list">
            <li v-for="parkingSpot in rentedParkingSpots">
                <a :href="`/parking-spot/${parkingSpot.parkingSpotId}`" class="link-to-parking-spot-detail">
                    <div class="single-parking-spot-container" >
                        <h1>{{parkingSpot.available}} - {{parkingSpot.streetAddress}}</h1>
                        <h1>{{parkingSpot.ownerId}}</h1>
                    </div>
                </a>
            </li>
        </ul>
   </div>
</template>
<script>
</script>
<style>

    nav {
        margin: 10px;
    }

   #normalNav {
    grid-area: nav;
    display: flex;
    background-color: #000000;
    }

    #normalNav a {
        opacity: 0.96;
        flex-grow: 1;
        display: block;
        text-align: center;
        color: white;
        font-weight: bold;
        line-height: 30px;
        min-width: 50px;
        overflow: hidden;
        text-decoration: none;
        margin: 5px;
        box-sizing: border-box;
        border-right: 1px solid white;
    }

    #normalNav #lastLink {
        border-right: 0;
    }

    #normalNav a:hover{
        opacity: 1.0;
        overflow: hidden;
        -webkit-box-shadow: 0px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 0px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 0px 10px 5px 0px rgba(0,0,0,0.25);
    }

    li{
        list-style-type: none;
    }

    .parking-spots-overview-list{
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
    }

    .parking-spot-overview-list li{
        padding: 10px;
        border: 1px solid white;
        border-radius: 15px;
    }

    .link-to-parking-spot-detail{
        width: 400px;
        height:100px;
        text-decoration: none;
        color: white;
    }

    div.single-parking-spot-container{
        overflow: hidden;
        width: 500px;
        background-color: #000000;
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
    }

    div.single-parking-spot-container:hover{
        opacity: 1.0;
        overflow: hidden;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    img.cover-image-frontpage {
        height: auto;
        width: 100%;
        padding-bottom: 20px;
        max-height: 280px;
    }
</style>