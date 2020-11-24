<template>
    <script type="module" src="components/payment-page-component.vue"></script>
</template>
<script>
Vue.component("payment-page", {
    template: "#payment-page",
    data: () => ({
        parkingSpotId: null,
        startDate: null,
        endDate: null,
        errors: []
    }),
    created() {
        fetch(`/api/parking-spot/${parkingSpotId}/available`)
            .then(res => res.json())
            .then(res => {
                this.available = res.available
            })
            .catch(() => alert("Error finding parking spot availability"))
    },
    methods: {
        checkForm: function (e) {
            const urlRegex = "/^(?:(?:(?:https?|ftp):)?\\/\\/)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\\.(?:[a-z\u00a1-\uffff]{2,})))(?::\\d{2,5})?(?:[/?#]\\S*)?$/i";
            if (this.startDate && this.endDate) return true;
            this.errors = [];
            if (!this.startDate) this.errors.push("Start date required");
            if (!this.endDate) this.errors.push("End date required");
            e.preventDefault();
        }
    }
});
</script>
<style>
</style>