import {ref, computed} from 'vue'
import {defineStore} from 'pinia'

/* Vue Composition API 의 setup 함수와 유사하게
* 반응형 프로퍼티와 메서드를 정의하는 함수를 작성하고,
* 노출하려는 프로퍼티와 메서드를 포함한 객체를 반환한다. */
export const useCounterStore = defineStore(
    'counter',
    () => {
        const count = ref(0)
        const doubleCount = computed(() => count.value * 2)

        function increment() {
            count.value++
        }

        return {count, doubleCount, increment}
    })
