# GroupDocs Viewer Java – Render Excel Multiple Sheets

## Overview
This showcase project demonstrates how to use **GroupDocs Viewer** (Java) to render selected worksheets of an Excel workbook (`.xlsx`) as separate PNG images. It is a minimal, runnable Maven project that helps developers understand how to work with multiple sheets using the library.

## Prerequisites
- **Java Development Kit (JDK) 8** or higher
- **Apache Maven** 3.5+ installed and added to your `PATH`
- An **Internet connection** for Maven to download dependencies

## License
GroupDocs Viewer requires a license file to work without evaluation limitations (watermarks, page limits, etc.).

1. **Obtain a temporary license** – Visit https://purchase.groupdocs.com/temporary-license/ to get a free 30‑day temporary license.
2. **Place the license file** – Save the downloaded `GroupDocs.Viewer.Java.lic` file in the **project root directory** (the same level where `pom.xml` resides).
3. **Without a license** – The library will run in evaluation mode which adds watermarks to rendered images and may impose other restrictions.

## Project Structure
```
groupdocs-viewer-java-render-excel-multiple-sheets/
│   pom.xml
│   README.md
│   GroupDocs.Viewer.Java.lic   (optional – place your license here)
│
├───src
│   └───main
│       └───java
│           └───com
│               └───groupdocs
│                   └───viewer
│                       └───examples
│                           └───RenderExcelMultipleSheetsExample.java
│
├───resources
│   ├───input
│   │   └───sample.xlsx          (sample Excel file – replace with your own)
│   └───output                  (generated images will be saved here)
```

## Setup & Run
1. **Clone or copy the project**
   ```bash
   git clone https://github.com/your-repo/groupdocs-viewer-java-render-excel-multiple-sheets.git
   cd groupdocs-viewer-java-render-excel-multiple-sheets
   ```
2. **Add your license file** (optional but recommended) – copy `GroupDocs.Viewer.Java.lic` into the project root.
3. **Place an Excel file** you want to render inside `resources/input/`. The project already contains a placeholder `sample.xlsx` which you can replace.
4. **Build the project**
   ```bash
   mvn clean compile
   ```
5. **Run the example**
   - Using Maven Exec plugin:
     ```bash
     mvn exec:java
     ```

## What Happens When You Run It?
- The program loads the license (if present).
- It checks `resources/input/sample.xlsx`. If the file is missing, execution stops with an error message.
- An output directory `resources/output/` is created if it does not already exist.
- The example renders worksheets in the range **pages 1–2** and saves them as PNG images with names like `page_1.png`, `page_2.png`, etc.
- Console output informs you about the progress and any possible errors.

## Customization
- **Change output format** – replace `PngViewOptions` with `JpgViewOptions` or other supported formats.
- **Render to PDF/HTML** – replace `PngViewOptions` with `PdfViewOptions` or `HtmlViewOptions` as needed.
- **Select specific sheets** – change the page range in `viewer.view(options, 1, 2)` to render more or fewer worksheets, or call `viewer.view(options)` to render all pages.

## Notes
- The sample Excel workbook (`sample.xlsx`) is intentionally empty; replace it with a real workbook containing multiple sheets to see the rendering in action.
- By default only the first two sheets are rendered; adjust the page range if you need all sheets.
- Ensure the `resources/input/` and `resources/output/` directories are at the same level as `pom.xml` as shown in the structure above.

---

*This is a showcase project for GroupDocs Viewer. It is intended for demonstration and educational purposes.*