import { shallowMount } from '@vue/test-utils'

import LoginPage from '@/views/Login.vue'

describe ('Component Login.vue', () => {

    it ('must change the value to true', () => {
    
     /// Create an instance of the component
     const wrapper = shallowMount(LoginPage);
  
     /// Evaluate that the default value is "false"
     expect(wrapper.vm.userActive).toBe(false);
  
     /// Execute the method that changes the value of the variable to "true"
     wrapper.vm.activeUser ();
  
     /// Evaluates that the new activeUser value is "true"
     expect(wrapper.vm.userActive).toBe(true);
  
    })

})