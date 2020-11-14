import { mount } from '@vue/test-utils'
import Vue from 'vue';
import Test from 'main/resources/vue/views/login-page.vue'


test('mount a vue component', async () => {
    const wrapper = mount(Test, {
        data() {
            return {
                show: true
            }
        }
    });
    expect(wrapper.text().toMatch('/parking-spots-overview.vue'))
});