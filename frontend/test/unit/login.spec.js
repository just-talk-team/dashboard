import { shallowMount } from '@vue/test-utils'
import LoginPage from '@/views/Login.vue'

test('Validate that the login fields are not empty', () => {
// render the component
const wrapper = shallowMount(LoginPage)

// must not allow `username` to be empty
wrapper.setData({user: ''.repeat(1)})

// verify that the error is displayed
expect(wrapper.find('. error').exists()).toBe(false)

// update the username data to be correct
wrapper.setData({user: 'vivieall7'})

// verify that the error has disappeared.
expect(wrapper.find('. error').exists()).toBe(false)
})