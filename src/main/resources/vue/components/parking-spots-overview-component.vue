<template id="parking-spots-overview">
   <div>
        <header>
            <h1>EZpark</h1>
        </header>
        <nav id="normalNav">
            <a href="/parking-spot">Home</a>
            <a href="/account/6648dfdc-9733-4a34-bfa0-e9de8c1ca78b/my-parking-spots">My Parking spots</a>
            <a id="lastLink" href="/">Logout</a>
        </nav>
        <h1>Parking</h1>
        <ul class="parking-spots-overview-list">
            <li v-for="parkingSpot in parkingSpots">
                <a :href="`/parking-spot/${parkingSpot.parkingSpotId}`" class="link-to-parking-spot-detail">
                    <div class="single-parking-spot-container" >
                        <h1>Location: {{parkingSpot.postalCode}} {{parkingSpot.poststed}}</h1>
                        <h1>Address: {{parkingSpot.streetAddress}} {{parkingSpot.streetNumber}}</h1>
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
    background-color: #1f1f23;
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
        -webkit-box-shadow: 0px 0px 5px 0px gray;
        -moz-box-shadow: 0px 0px 5px 0px gray;
        box-shadow: 0px 0px 5px 0px gray;
    }

    li{
        list-style-type: none;
    }

    ul{
    padding-inline-start: 0px;
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
        width: 500px;
        background-color: #191919;
        margin: 0 auto;
        text-align: center;
        border-style: groove;
        border-color: dimgray;
    }

    div.single-parking-spot-container:hover{
        background-color: #0d0d0d;
    }

    img.cover-image-frontpage {
        height: auto;
        width: 100%;
        padding-bottom: 20px;
        max-height: 280px;
    }
</style>