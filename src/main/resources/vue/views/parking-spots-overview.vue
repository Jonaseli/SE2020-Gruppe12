<template>
    <script type="module" src="components/parking-spots-overview-component.vue"></script>
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
</style>