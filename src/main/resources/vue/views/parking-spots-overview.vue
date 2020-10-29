<template id="parking-spots-overview">
   <div>
       <h1>Parking</h1>
        <ul class="parking-spots-overview-list">
            <li v-for="parkingSpot in parkingSpots">
                <a :href="`/parking-spot/${parkingSpot.streetAddress}`" class="link-to-parking-spot-detail">
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

    Vue.component("parking-spots-overview", {
        template: "#parking-spots-overview",
        data: () => ({
            parkingSpots: [],
        }),
        created() {
            fetch("/api/parking-spot")
                .then(res => res.json())
                .then(res => this.parkingSpots = res)
                .catch(() => alert("Error while fetching parkingspots"));
        }
    });
</script>
<style>
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