<template>
    <script type="module" src="components/parking-spot-detail-component.vue"></script>
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
        console.log(parkingSpotId);

        fetch(`/api/parking-spot/${parkingSpotId}`)
            .then(res => res.json())
            .then(res => {
                this.parkingSpot = res;

                let ownerId = this.parkingSpot.owner
                console.log(this.parkingSpot)
                console.log(ownerId)
                fetch(`/api/account/${ownerId}`)
                    .then(res => res.json())
                    .then(res => this.owner = res)
                    .catch(() => alert("Error while fetching owner"));
            }).catch(() => alert("Error while fetching parking spot"));
    }
});
</script>
<style>
</style>