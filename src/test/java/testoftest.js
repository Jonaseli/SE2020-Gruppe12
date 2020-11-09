import { mount } from '@vue/test-utils'
import Component from '@../parking-spots-overview.vue'

test('mount a vue component', async () => {
    const wrapper = mount(Component, {
        data() {
            return {
                show: true
            }
        }
    });
    expect(wrapper.text().toMatch('/parking-spots-overview.vue'))
});

