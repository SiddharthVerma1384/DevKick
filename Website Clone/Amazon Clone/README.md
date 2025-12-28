# Amazon Website UI Clone

This project is a **UI clone of the Amazon website header and layout**, created purely for **learning and practice purposes** using HTML and CSS.

The goal of this project is to **understand real-world website structure** and clearly document **what I learned while building it**.

---

## Header

While building the header section, I learned many important frontend concepts:

### 1. Creating Multiple Containers
- How to divide a header into **multiple container classes**
- Each container handles a specific part (logo, search bar, cart, etc.)
- Helps in **clean structure and easy styling**

---

### 2. Hover and Focus

#### Hover
- `:hover` is used when the **mouse pointer is placed over an element**
- Changes are **visible only while hovering**

Example use cases:
- Navbar item highlight
- Button hover effects

#### Focus
- `:focus` is applied when an element is **clicked or selected**
- Mostly used for **interactive / clickable elements**

📌 **Important Note**
- `focus` is **NOT applicable to `div`**
- It works with:
  - `input`
  - `button`
  - `a`
  - `span` (if made focusable)

---

### 3. Difference Between Hover and Focus

| Hover | Focus |
|-----|------|
| Triggered by mouse | Triggered by click/keyboard |
| Temporary | Remains until focus is lost |
| Used for UI effects | Used for inputs & accessibility |

---

### 4. Use of `span`

I learned when and why to use `span`:
- Used when I want to make **specific changes inside a paragraph**
- Helps target **selected words or parts**, not the whole text

Example use cases:
- Highlighting text
- Styling a word inside `<p>`
- Applying CSS to a small portion only

---

### 5. Margin vs Padding

#### Margin
- Used to manage **space between elements**
- Controls **outer spacing**

#### Padding
- Used to manage **space inside the container**
- Controls space between **content and border**

📌 Padding affects the **inner content**, margin does not.

#### Visual Explanation


---

### 6. Flexbox Alignment

By using `display: flex`, I learned:

- `align-items: center`
  - Used to **align items vertically**

- `justify-content: center`
  - Used to **align items horizontally**

These properties help in **proper alignment without using margins**.

---

### 7. Sprite Sheets ⭐ (Very Important)

Sprite sheets are **large image files containing multiple icons/logos/images**.

#### Why companies use sprite sheets:
- Reduces number of network requests
- Improves performance
- Keeps all icons in one place

#### Key Learning:
- Sprite sheets are used via **CSS `background-image`**
- NOT using `<img src="">` in HTML
- Specific icon is shown using `background-position`

---

### 8. How to Find Sprite Coordinates

There are two main ways:

1. **Inspecting the live website**
   - Use browser dev tools
   - Check background-position values

2. **Using Sprite Cow Tool**
   - Upload the sprite sheet
   - Select desired icon
   - Tool gives:
     - background-position
     - width & height

---

### 9. Gap, Space-Around, Space-Between

- `gap`
  - Adds space **between flex items only**

- `space-between`
  - First item at start, last at end
  - Equal space between items

- `space-around`
  - Equal space around each item
  - Outer space is also included

---

### 10. Position Relative vs Absolute

#### Position: relative
- Used on the **parent element**
- Creates a reference point

#### Position: absolute
- Used on the **child element**
- Positioned relative to the nearest relative parent

📌 Used when exact placement is required (icons, badges, overlays).

---

### 11. Box Shadow

- `box-shadow` can act like a **soft border**
- Used instead of `border` for:
  - Modern UI look
  - Depth and elevation effect

Common use:
- Cards
- Header separation
- Buttons

---

## Status
🚧 Work in progress  
More sections and improvements will be added as I continue learning.

---

## Author
Siddharth Verma  
Learning Frontend Development 🚀
