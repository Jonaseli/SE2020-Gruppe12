<template>
    <script type="module" src="components/parking-spot-detail-component.vue"></script>
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
            console.log(parkingSpotId);
            fetch(`/api/parking-spot/${parkingSpotId}`)
                .then(res => res.json())
                .then(res => this.parkingSpot = res)
                .catch(() => alert("Error while fetching parkingspot"))
            /*
                fetch(`/api/parking-spot/${parkingSpotId}`)
                .then(res => res.json())
                .then(res => this.post = res)
                .catch(() => alert("Error while fetching owner"));
            */
        }
    });
</script>
<style>
</style>