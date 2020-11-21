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
                    <div class="single-parking-spot-container" >
                        <h1>Create new parking spot</h1>
                    </div>
                </a>
            </li>
        </ul>
        <h1>Owned parking spots</h1>
        <ul class="parking-spots-overview-list">
            <li v-for="parkingSpot in ownedParkingSpots">
                <a :href="`/parking-spot/${parkingSpot.parkingSpotId}`" class="link-to-parking-spot-detail">
                    <div class="single-parking-spot-container" >
                        <h1>Location: {{parkingSpot.postalCode}} {{parkingSpot.poststed}}</h1>
                        <h1>Address: {{parkingSpot.streetAddress}} {{parkingSpot.streetNumber}}</h1>
                    </div>
                </a>
            </li>
        </ul>
        <h1>Rented parking spots</h1>
        <ul class="parking-spots-overview-list">
            <li v-for="parkingSpot in rentedParkingSpots">
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
</style>