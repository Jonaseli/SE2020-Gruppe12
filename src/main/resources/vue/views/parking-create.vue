<template>
    <script type="module" src="components/parking-create-component.vue"></script>
</template>
<script>
    Vue.component("parking-create", {
        template: "#parking-create",
        data: () => ({
            accountId: null,
            type: null,
            width: null,
            height: null,
            postalCode: null,
            streetAddress: null,
            streetNumber: null,
            pictureURL: null,
            errors: []
        }),
        created() {
            const accountId = this.$javalin.pathParams["account-id"];
            fetch(`/api/account/${accountId}`)
                .then(res => res.json())
                .then(res => {this.account = res.accountId})
                .catch(() => alert("User not found"))
        },
        methods:{
            checkForm:function(e) {
                const urlRegex = "/^(?:(?:(?:https?|ftp):)?\\/\\/)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\\.(?:[a-z\u00a1-\uffff]{2,})))(?::\\d{2,5})?(?:[/?#]\\S*)?$/i";
                if(this.type && this.width && this.height && this.postalCode && this.streetAddress && this.streetNumber) return true;
                this.errors = [];
                if (!this.type) this.errors.push("Type required");
                if (!this.width) this.errors.push("Width required");
                if (!this.height) this.errors.push("Height required");
                if (!this.postalCode) this.errors.push("Postal code required");
                if (!this.streetAddress) this.errors.push("Street address required");
                if (!this.streetNumber) this.errors.push("Street number required");
                e.preventDefault();
            }
        }
    });
</script>
<style>
</style>