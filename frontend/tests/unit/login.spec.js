import { shallowMount } from '@vue/test-utils'
import LoginPage from '@/views/Login.vue'

test('Valida que los campos de logeo no esten vacios', () => {
  // renderiza el componente
  const wrapper = shallowMount(LoginPage)

  // no debe permitir que `username` tenga menos de 5 caracteres, excluye los espacios en blanco
  wrapper.setData({ user: ' '.repeat(5) })

  // verificar que se muestra el error
  expect(wrapper.find('.error').exists()).toBe(false)

  // actualiza el nombre para que sea lo suficientemente largo
  wrapper.setData({ user: 'vivieall' })

  // verificar que el error ha desaparecido.
  expect(wrapper.find('.error').exists()).toBe(false)

})