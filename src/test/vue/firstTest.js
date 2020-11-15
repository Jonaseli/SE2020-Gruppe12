import { mount } from '@vue/test-utils'
import Component from 'main/resources/vue/components/login-buttons.vue'

test('mount a vue component', () => {
    const wrapper = mount(Component)
    expect(wrapper.find('div').exists()).toBe(true);
    expect(wrapper.find('button').exists()).toBe(false);
});