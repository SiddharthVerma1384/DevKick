import { createSlice, nanoid } from "@reduxjs/toolkit";

const initialState = {
    todos: [{id: 1, text: "Hello world"}]
}

export const todoSlice = createSlice({
    name: 'todo',
    initialState,
    reducers: {
        addTodo: (state, action) => {
            const todo= {
                id: nanoid(), 
                text: action.payload,
            }
            state.todos.push(todo)
        },
        removeToDo: (state, action) => {
            state.todos = state.todos.filter((todo) => todo.id !== action.payload)
        },
    }
})

export const {addTodo, removeToDo} = todoSlice.actions

export default todoSlice.reducer