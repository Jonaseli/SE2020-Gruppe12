<template id="parkingSpots-overview">
   <div>
       <h1>Planet systems</h1>
        <ul class="parkingSpots-overview-list">
            <li v-for="parkingSpot in parkingSpots">
                <a :href="`/posts/${parkingSpot.streetAddress.trim()}`" class="link-to-parkingSpot-details">
                    <div class="single-parkingSpot-container" >
                        <h1>{{parkingSpot.available}} - {{parkingSpot.streetAddress}}</h1>
                        <h1>{{parkingSpot.ownerId}}</h1>
                    </div>
                </a>
            </li>
        </ul>
   </div>
</template>
<script>
    Vue.component("parkingSpots-overview", {
        template: "#parkingSpots-overview",
        data: () => ({
            parkingSpots: [],
        }),
        created() {
            fetch("/api/parkingSpots")
                .then(res => res.json())
                .then(res => {
                   this.parkingSpots = res;
                })
                .catch(() => alert("Error while fetching parkingspots"));
        }
    });
</script>
<style>
    li{
        list-style-type: none;
    }

    .parkingSpots-overview-list{
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
    }

    .parkingSpot-overview-list li{
        padding: 10px;
        border: 1px solid white;
        border-radius: 15px;
    }

    .link-to-parkingSpot-details{
        width: 400px;
        height:100px;
        text-decoration: none;
        color: white;
    }

    div.single-parkingSpot-container{
        overflow: hidden;
        width: 500px;
        background-color: #000000;
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
    }

    div.single-parkingSpot-container:hover{
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