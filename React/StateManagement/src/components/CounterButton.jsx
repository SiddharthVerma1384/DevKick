import {useCounterStore} from '../store/counterStore.js'

function CounterButton() {
    const increase = useCounterStore((state) => state.increase)

    const decrease = useCounterStore((state) => state.decrease)
    return (
        <>
            <button onClick={increase}> + </button>
            <button onClick={decrease}> - </button>
        </>
    )
}

export default CounterButton