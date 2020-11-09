<template id = "parking-spot-detail">
    <div class = "content-wrapper">
        <div v-if="parkingSpot" class ="detail-parking-spot-container">
            <img v-if="parkingSpot.pictureURL" class="cover-image" v-bind:src="parkingSpot.pictureURL">
            <img v-else class="cover-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
            <h1>{{parkingSpot.owner}}</h1>
        </div>
    </div>
</template>

<script>
    Vue.component("parking-spot-detail", {
        template: "#parking-spot-detail",
        data: () => ({
            parkingSpot: null,
            post: [],

        }),
        created() {
            const parkingSpotId = this.$javalin.pathParams["parking-spot-id"];
            fetch(`api/parking-spot/${parkingSpotId}`)
                .then(res => res.json())
                .then(res => this.parkingSpot = res)
                .catch(() => alert("Error while fetching parkingspot"))
            const postId = this.$javalin.pathParams['post-id'];
                fetch(`api/parking-spot/${parkingSpotId}/posts/${postId}`)
                .then(res => res.json())
                .then(res => this.post = res)
                .catch(() => alert("Error while fetching posts"));

        }
    });
</script>
<style>

.detail-parking-spot-container{
color:black;
display: flex;
flex-wrap: wrap;
justify-content: space-around;

}

#sortList{
display: flex;
flex-wrap: wrap;
justify-content: center;
margin-top: 30px;
margin-bottom: 30px;
}

#sortList li{
padding: 10px;
margin: 10px;
border: 1px solid white;
color: white;
border-radius: 15px;
}

#sortList li a{
color: white;
text-decoration: none;
font-weight: bold;
}

#sortList li:hover{
border: 2px solid white;
}

div.detail-parking-spot-container{
padding: 10px;
overflow: hidden;
width: 750px;
margin: 0 auto;
background-color: rgba(20, 20, 20, 0.98);
opacity: 0.96;
color: white;
-webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
-moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
}

div.single-planet-container{
overflow: hidden;
color: white;
background-color: rgba(0, 0, 0, 0.98);
margin: 0 auto;
opacity: 0.96;
text-align: center;
}

.single-star-container{
height:100px;
width:40%;
background-color: #F0FFFF;
opacity: 0.96;
text-align: center;
margin-left: 34%;
}


div.single-star-container:hover{
height:115px;
opacity:1.0;

}

img.cover-image {
height: auto;
width: 50%;
margin: 5px;
float: left;
}

img.list-image {
width: 140px;
padding-bottom: 20px;
transition: transform .2s;
}

.list-image:hover{
transform: scale(1.1);
}

h1{
font-size:18px;
padding-top: 10px;
}

.link-to-planet-details{
width: 400px;
height:100px;
text-decoration: none;
color:black;
}

.button {
padding: 10px;
margin: 10px;
border: 1px solid white;
color: white;
border-radius: 15px;
}

button a{
color: white;
text-decoration: none;
font-weight: bold;
}

.button:hover{
border: 2px solid white;
}

</style>