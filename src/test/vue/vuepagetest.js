import { mount } from '@vue/test-utils'
import Vue from 'vue'
import Test from 'main/resources/vue/views/login-page.vue'


test('mount a vue component', () => {
    const wrapper = mount(Test)
    window.Vue = require('vue')
    expect(wrapper.attributes()).toBe('5')
    expect(wrapper.text()).toMatch('/my-parking-spots.vue');
});