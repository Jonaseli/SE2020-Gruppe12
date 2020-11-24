<template id="admin-page">
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
                    <div class="single-parking-spot-container">
                        <h1>ID: {{ account.accountId }}</h1>
                        <h1>Display Name: {{ account.displayName }}</h1>
                        <h1>Suspended: {{ account.suspended }}</h1>
                        <div>
                            <a :href="`/api/admin/account/suspend/${account.accountId}`"
                               class="link-to-parking-spot-detail">
                                <div class="admin-controls">
                                    <h1>Suspend/Unsuspend</h1>
                                </div>
                            </a>
                            <a :href="`/api/admin/account/${account.accountId}`" class="link-to-parking-spot-detail">
                                <div class="admin-controls">
                                    <h1>Delete</h1>
                                </div>
                            </a>
                        </div>
                    </div>
                </a>
            </li>
        </ul>
        <h1>All Parking spots</h1>
        <ul class="parking-spots-overview-list">
            <li v-for="parkingSpot in allParkingSpots">
                <a :href="`/admin-page`" class="link-to-parking-spot-detail">
                    <div class="single-parking-spot-container">
                        <h1>Location: {{ parkingSpot.postalCode }} {{ parkingSpot.postalCode }}</h1>
                        <h1>Address: {{ parkingSpot.streetAddress }} {{ parkingSpot.streetNumber }}</h1>
                        <div>
                            <a :href="`/api/admin/parking-spot/${parkingSpot.parkingSpotId}`"
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
        <h1>All Posts</h1>
        <ul class="parking-spots-overview-list">
            <li v-for="post in allPosts">
                <a :href="`/admin-page`" class="link-to-parking-spot-detail">
                    <div class="single-parking-spot-container">
                        <h1>ID: {{ post.postId }}</h1>
                        <h1>Price: {{ post.price }}</h1>
                        <div>
                            <a :href="`/api/admin/post/${post.postId}`" class="link-to-parking-spot-detail">
                                <div class="admin-controls">
                                    <h1>Delete</h1>
                                </div>
                            </a>
                        </div>
                    </div>
                </a>
            </li>
        </ul>
        <h1>All Reservations</h1>
        <ul class="parking-spots-overview-list">
            <li v-for="reservation in allReservations">
                <a :href="`/admin-page`" class="link-to-parking-spot-detail">
                    <div class="single-parking-spot-container">
                        <h1>ID: {{ reservation.reservationId }}</h1>
                        <h1>Time: {{ reservation.startTime }} - {{ reservation.endTime }}</h1>
                        <div>
                            <a :href="`/api/admin/reservation/${reservation.reservationId}`"
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
    div.admin-controls {
        overflow: hidden;
        width: 500px;
        background-color: #5a0606f5;
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
        border-top-style: groove;
        border-color: dimgray;
    }

    div.admin-controls div {
        float: left;
    }


    div.admin-controls:hover {
        background-color: #7b0606f5;
    }
</style>