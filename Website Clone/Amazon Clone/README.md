# Amazon UI Clone (HTML & CSS)

This project is a frontend **UI clone inspired by Amazon**, built using **HTML and CSS**.
The goal of this project was to replicate a complex, real-world e-commerce interface while following clean structure and scalable styling practices. Building this clone strengthened my understanding of core frontend concepts and improved my ability to translate UI designs into responsive, maintainable code using pure HTML and CSS.

---

## Tech Stack

* **HTML5** – Semantic structure and layout
* **CSS3** – Styling, layout, positioning, and responsiveness

---


## Key Learnings & Concepts

### 1. CSS Box Model

* Clear understanding of **padding vs margin**

  * **Padding**: Space inside an element (between content and border)
  * **Margin**: Space outside an element (distance from other elements)

  ![Margin Vs Padding](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkNgE4u3KHPiitTvii0_-_a-1anIdN2d8p7Q&s)
---

### 2. Icons, Favicons & Logos

* Understood the **difference between icons, favicons, and logos**
* Learned **how to link favicons** properly in HTML

---

### 3. Sprite Sheets

* Learned about **sprite sheets** used by companies to bundle multiple icons/images into a single file
* Used sprite sheets via:

  ```css
  background: url('sprite-sheet-link');

  ![Sprite Sheets used in this clone](https://m.media-amazon.com/images/G/31/gno/sprites/nav-sprite-global-1x-reorg-privacy._CB546381437_.png, https://m.media-amazon.com/images/S/sash/ydDD9hnRfziI$y7.png, https://m.media-amazon.com/images/S/sash/x6ok$LYiGGUKJXl.png, https://m.media-amazon.com/images/G/31/gno/sprites/nav-sprite-global-1x-reorg-privacy._CB546381437_.png, https://m.media-amazon.com/images/S/sash/MAbi1rCjQI9H2y0.png)


  ```
* Displayed specific images by:

  * Using `background-position`
  * Adjusting **width and height**
  * Understanding how coordinates work to access the correct portion of the sprite

---

### 4. Lists & Navigation

* Used **unordered lists (`<ul>`)** for navigation and layout
* Customized list appearance using CSS
* Removed default bullets using:

  ```css
  list-style: none;
  ```

---

### 5. Select Menu Customization

* Removed default browser styling of `<select>` using:

  ```css
  appearance: none;
  -webkit-appearance: none;
  -moz-appearance: none;
  ```
* Helped in creating **custom-styled dropdown menus**

---

### 6. Text & Links Styling

* Used `text-decoration` to control text appearance
* Styled anchor tags (`<a>`) according to design needs

---

### 7. CSS Positioning

* Gained clarity on **position: relative vs position: absolute**

  * **Relative**: Element stays in normal flow but can be adjusted using `top`, `left`, `right`, `bottom`
  * **Absolute**: Positioned relative to the nearest parent with `position: relative`

---

### 8. Box Shadow

* Used `box-shadow` to create borders and depth effects
* Understood shadow offsets and directions

  * Positive values move shadows to the **right/bottom**
  * Negative values move shadows to the **left/top**

---

### 9. Flexbox Layout

* Used `justify-content` and `align-items` effectively
* Applied `flex-wrap: wrap` to prevent content overflow, especially for images

---

### 10. Responsive Sizing

* Preferred `rem` over `px` for font sizing for better scalability
* Used `max-width`, `min-width`, `max-height`, and `min-height` to:

  * Prevent image stretching
  * Maintain aspect ratio
  * Avoid unnecessary shrinking

---

### 11. Hover Effects & Flyouts

* Used `opacity`, `visibility`, and `transition` for smooth flyout animations
* Controlled interactivity using `pointer-events` along with opacity

---

## Development Insight ⭐

* Used **multiple containers (`div`s)** to simplify layout adjustments
* Temporarily applied borders to containers to:

  * Visualize layout structure
  * Adjust height, width, position, and alignment

> Not a pro tip, but this approach helped me a lot while building and debugging the UI.

---

## Conclusion

This project strengthened my frontend fundamentals and gave me practical experience in building a **production-like UI** using only HTML and CSS. It improved my confidence in handling layouts, positioning, responsive sizing, and UI interactions, forming a strong foundation for more advanced frontend and full‑stack projects.
