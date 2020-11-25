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
                    <div class="single-parking-spot-container">
                        <h1>Create new parking spot</h1>
                    </div>
                </a>
            </li>
        </ul>
        <h1>Owned parking spots</h1>
        <ul class="parking-spots-overview-list">
            <li v-for="parkingSpot in ownedParkingSpots">
                <a :href="`/parking-spot/${parkingSpot.parkingSpotId}`" class="link-to-parking-spot-detail">
                    <div class="single-parking-spot-container">
                        <h1>Location: {{ parkingSpot.postalCode }} {{ parkingSpot.city }}</h1>
                        <h1>Address: {{ parkingSpot.streetAddress }} {{ parkingSpot.streetNumber }}</h1>
                        <div>
                            <a :href="`/api/user/delete-parking-spot/${parkingSpot.parkingSpotId}`"
                               class="link-to-parking-spot-detail">
                                <div class="admin-controls">
                                    <h1>Delete</h1>
                                </div>
                            </a>
                        </div>
                    </div>
                </a>
            </li>
        </ul>
        <h1>Rented parking spots</h1>
        <ul class="parking-spots-overview-list">
            <li v-for="parkingSpot in rentedParkingSpots">
                <a :href="`/parking-spot/${parkingSpot.parkingSpotId}`" class="link-to-parking-spot-detail">
                    <div class="single-parking-spot-container">
                        <h1>Location: {{ parkingSpot.postalCode }} {{ parkingSpot.city }}</h1>
                        <h1>Address: {{ parkingSpot.streetAddress }} {{ parkingSpot.streetNumber }}</h1>
                        <div>
                            <a :href="`/api/user/delete-reservation/${parkingSpot.parkingSpotId}`"
                               class="link-to-parking-spot-detail">
                                <div class="admin-controls">
                                    <h1>Delete</h1>
                                </div>
                            </a>
                        </div>
                    </div>
                </a>
            </li>
        </ul>
    </div>
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