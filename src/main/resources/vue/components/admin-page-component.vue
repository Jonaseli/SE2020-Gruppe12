<template id ="admin-page">
   <div>
        <header>
            <h1>EZpark</h1>
        </header>
        <nav id="normalNav">
            <a href="/admin-page">Home</a>
            <a id="lastLink" href="/">Logout</a>
        </nav>
        <h1>All Accounts</h1>
        <ul class="parking-spots-overview-list">
            <li v-for="account in allAccounts">
                <a :href="`/admin-page`" class="link-to-parking-spot-detail">
                    <div class="single-parking-spot-container" >
                        <h1>ID: {{account.accountId}}</h1>
                        <h1>Display Name: {{account.displayName}}</h1>
                    </div>
                </a>
            </li>
        </ul>
        <h1>All Parking spots</h1>
        <ul class="parking-spots-overview-list">
            <li v-for="parkingSpot in allParkingSpots">
                <a :href="`/admin-page`" class="link-to-parking-spot-detail">
                    <div class="single-parking-spot-container" >
                        <h1>Location: {{parkingSpot.postalCode}} {{parkingSpot.poststed}}</h1>
                        <h1>Address: {{parkingSpot.streetAddress}} {{parkingSpot.streetNumber}}</h1>
                    </div>
                </a>
            </li>
        </ul>
        <h1>All Posts</h1>
        <ul class="parking-spots-overview-list">
            <li v-for="post in allPosts">
                <a :href="`/admin-page`" class="link-to-parking-spot-detail">
                    <div class="single-parking-spot-container" >
                        <h1>ID: {{post.postId}}</h1>
                        <h1>Price: {{post.price}}</h1>
                    </div>
                </a>
            </li>
        </ul>
        <h1>All Reservations</h1>
        <ul class="parking-spots-overview-list">
            <li v-for="reservation in allReservations">
                <a :href="`/admin-page`" class="link-to-parking-spot-detail">
                    <div class="single-parking-spot-container" >
                        <h1>ID: {{reservation.reservationId}}</h1>
                        <h1>Time: {{reservation.startTime}} - {{reservation.endTime}}</h1>
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