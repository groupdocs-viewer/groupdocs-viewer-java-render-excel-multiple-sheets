package com.groupdocs.viewer.examples;

import com.groupdocs.viewer.License;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.PngViewOptions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Demonstrates how to render selected worksheets of an Excel file as separate images using GroupDocs Viewer.
 * <p>
 * The example expects an Excel file (<code>sample.xlsx</code>) placed in the <code>resources/input/</code>
 * directory (project root). Rendered images are saved to <code>resources/output/</code>.
 * </p>
 */
public class RenderExcelMultipleSheetsExample {

    private static final String INPUT_FILE = "resources/input/sample.xlsx";
    private static final String OUTPUT_DIR = "resources/output/";
    private static final String LICENSE_FILE = "GroupDocs.Viewer.Java.lic";

    /**
     * Loads the GroupDocs Viewer license if the license file exists.
     * <p>
     * To get a temporary license, visit:
     * <a href="https://purchase.groupdocs.com/temporary-license/">https://purchase.groupdocs.com/temporary-license/</a>.
     * Place the downloaded <code>GroupDocs.Viewer.Java.lic</code> file in the project root directory.
     * Without a license the library works in evaluation mode with watermarks and other limitations.
     * </p>
     *
     * @param licensePath path to the license file relative to the project root
     */
    public static void loadLicense(String licensePath) {
        File licenseFile = new File(licensePath);
        if (licenseFile.exists()) {
            try {
                License license = new License();
                license.setLicense(licensePath);
                System.out.println("GroupDocs Viewer license loaded successfully.");
            } catch (Exception e) {
                System.err.println("Failed to load GroupDocs Viewer license: " + e.getMessage());
            }
        } else {
            System.out.println("License file not found at " + licensePath + ". Running in evaluation mode.");
        }
    }

    /**
     * Renders each worksheet of the given Excel file as separate PNG images.
     * <p>
     * The method creates the output directory if it does not exist, then iterates over the pages
     * returned by GroupDocs Viewer. For Excel files each worksheet is treated as a separate page.
     * Images are saved with the pattern <code>sheet_{index}.png</code> inside the output directory.
     * </p>
     */
    public static void renderExcelWorksheets() {
        // Ensure output directory exists
        Path outDirPath = Paths.get(OUTPUT_DIR);
        try {
            if (!Files.exists(outDirPath)) {
                Files.createDirectories(outDirPath);
                System.out.println("Created output directory: " + outDirPath.toAbsolutePath());
            }
        } catch (Exception e) {
            System.err.println("Failed to create output directory: " + e.getMessage());
            return;
        }
        Path pageFilePathFormat = outDirPath.resolve("page_{0}.png");
        File inputFile = new File(INPUT_FILE);
        if (!inputFile.exists()) {
            System.err.println("Input file not found: " + INPUT_FILE);
            return;
        }

        try (Viewer viewer = new Viewer(INPUT_FILE)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);
            // Render only the first two worksheets; adjust the range to include more sheets.
            viewer.view(options, 1, 2);
        } catch (Exception e) {
            System.err.println("Error during rendering: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Load license if available
        loadLicense(LICENSE_FILE);
        // Perform the rendering demonstration
        renderExcelWorksheets();
    }
}
