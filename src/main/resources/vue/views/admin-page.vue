<template>
    <script type="module" src="components/admin-page-component.vue"></script>
</template>
<script>
    Vue.component("admin-page", {
        template: "#admin-page",
        data: () => ({
            allAccounts: [],
            allParkingSpots: [],
            allPosts: [],
            allReservations: [],
        }),
        created() {
            fetch(`/api/account`)
                .then(res => res.json())
                .then(res => this.allAccounts = res)
                .catch(() => alert("Error fetching accounts"))
            fetch(`api/parking-spot`)
                .then(res => res.json())
                .then(res => this.allParkingSpots = res)
                .catch(() => alert("Error while fetching parking spots"));
            fetch(`api/post`)
                .then(res => res.json())
                .then(res => this.allPosts = res)
                .catch(() => alert("Error while fetching posts"));
            fetch(`api/reservation`)
                .then(res => res.json())
                .then(res => this.allReservations = res)
                .catch(() => alert("Error while fetching reservations"));
        }
    });
</script>
<style>
</style>