<template>
    <script type="module" src="components/my-parking-spots-component.vue"></script>
</template>
<script>
Vue.component("my-parking-spots", {
    template: "#my-parking-spots",
    data: () => ({
        account: null,
        ownedParkingSpots: [],
        rentedParkingSpots: [],
        historyParkingSpots: [],
    }),
    created() {
        const accountId = this.$javalin.pathParams["account-id"];
        fetch(`/api/account/${accountId}`)
            .then(res => res.json())
            .then(res => {
                this.account = res.accountId
            })
            .catch(() => alert("User not found"))
        fetch(`/api/account/${accountId}/my-parking-spots/owned-parking-spots`)
            .then(res => res.json())
            .then(res => this.ownedParkingSpots = res)
            .catch(() => alert("Error while fetching owned parkingspots"));
        fetch(`/api/account/${accountId}/my-parking-spots/rented-parking-spots`)
            .then(res => res.json())
            .then(res => this.rentedParkingSpots = res)
            .catch(() => alert("Error while fetching rented parkingspots"));
    }
});
</script>
<style>
</style>