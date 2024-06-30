package Models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import java.awt.geom.AffineTransform;
import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.awt.geom.misc.RenderingHints;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfImageObject;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

import Controllers.components_web_controller;

public class Pagina_ambiental_carrete_tip 
{
	
	private int colorOption; // almacenar la opción de color
	private String tittle;
	private String subtittle;
	private String text;
	private String link;
	
	public Pagina_ambiental_carrete_tip(int colorOption, String tittle, String subtittle, String text, String link)
	{
		this.colorOption = colorOption;
		this.tittle = tittle;
		this.subtittle = subtittle;
		this.text = text;
		this.link = link;
	}
	
	public void generate_tip() throws Exception {
	    try {
	        Document document = new Document();
	        String dest = components_web_controller.getProperty("ASSETS_CARRETE_PDF");
	        dest = dest.concat(tittle + ".pdf");
	        
	        String dest2 = components_web_controller.getProperty("ASSETS_CARRETE_IMAGE");
	        dest2 = dest2.concat(tittle + ".png");
	        
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));

	        // Añadir evento para encabezado y pie de página
	        HeaderFooter event = new HeaderFooter(colorOption, tittle, subtittle, text, link);
	        writer.setPageEvent(event);

	        document.open();
	        
	        // Aquí puedes agregar contenido al documento
	        Paragraph paragraph = new Paragraph(" ");
	        document.add(paragraph);
	        
	        document.close();
	        
	        convertPDFToImage(dest, dest2);
	        System.out.println("PDF creado");

	    } catch (FileNotFoundException ex) {
	        System.out.println(ex);
	    }
	}

	// Clase para manejar el encabezado y el pie de página
	static class HeaderFooter extends PdfPageEventHelper 
	{
		
		// Constantes de colores y fuentes
		private static int colorOption;
        private static final BaseColor YELLOW = new BaseColor(249, 219, 0);
        private static final BaseColor GREEN = new BaseColor(19, 106, 58);
        private static final BaseColor GREEN_LIGTH = new BaseColor(143, 193, 69);
        private static final BaseColor ORANGE = new BaseColor(250, 186, 40);
        private static final BaseColor BLUE = new BaseColor(67, 191, 239);

	    private static final Font HEADER_FONT = new Font(Font.FontFamily.UNDEFINED, 20, Font.BOLD, GREEN_LIGTH);
	    private static final Font SUBHEADER_FONT = new Font(Font.FontFamily.UNDEFINED, 10, Font.NORMAL, GREEN_LIGTH);
	    private static final Font FOOTER_FONT = new Font(Font.FontFamily.UNDEFINED, 10, Font.ITALIC, GREEN_LIGTH);

	    // Contenido del encabezado y pie de página
	    private Phrase header1 = new Phrase("Universidad San Carlos de Guatemala", HEADER_FONT);
	    private Phrase header2 = new Phrase("Comisión Ambiental, Cambio Climático, Seguridad y", SUBHEADER_FONT);
	    private Phrase header3 = new Phrase("Resiliencia del Consejo Superior Universitario.", SUBHEADER_FONT);
	    private Phrase footer;
	    
		private String tittle;
		private String subtittle;
		private String text;
		
	    private BaseColor headerFooterColor;
	    private BaseColor largeSquareColor;
	    
	    public HeaderFooter(int colorOption, String tittle, String subtittle, String text,  String link) {
	    	this.colorOption = colorOption;
	    	this.tittle = tittle;
	    	this.subtittle = subtittle;
	    	this.text = text;
	    	
	    	footer = new Phrase(link, FOOTER_FONT);
	    	
            switch (colorOption) {
                case 1:
                    headerFooterColor = GREEN;
                    largeSquareColor  = GREEN ; // Ajuste basado en los colores disponibles
                    break;
                case 2:
                    headerFooterColor = ORANGE;
                    largeSquareColor  = ORANGE;
                    break;
                case 3:
                    headerFooterColor = BLUE;
                    largeSquareColor  = BLUE;
                    break;
                case 4:
                    headerFooterColor = YELLOW;
                    largeSquareColor  =  YELLOW;
                    break;
                default:
                    headerFooterColor = GREEN_LIGTH;
                    largeSquareColor  = GREEN_LIGTH;
                    break;
            }
        }

	    @Override
	    public void onEndPage(PdfWriter writer, Document document) {
	        PdfContentByte cb = writer.getDirectContent();

	        float headerHeight = 150; // Altura deseada del rectángulo del encabezado (ajusta según necesites)
	        float pageWidth = document.getPageSize().getWidth();

	        drawHeader(cb, document, headerHeight, pageWidth);
	        drawFooter(cb, document, pageWidth);
	        drawAdditionalElements(cb, document);
	        try {
				drawImages(cb, document, pageWidth);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    private void drawHeader(PdfContentByte cb, Document document, float headerHeight, float pageWidth) {
	    	cb.setColorFill(headerFooterColor); // Utilizar el color dinámico para el encabezado
	        cb.rectangle(0, document.top() + 35, pageWidth, -headerHeight); // Dibujar fondo para encabezado
	        cb.fill();

	        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, header1, document.leftMargin(), document.top() - 20, 0);
	        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, header2, document.leftMargin(), document.top() - 35, 0);
	        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, header3, document.leftMargin(), document.top() - 50, 0);
	    }

	    private void drawImages(PdfContentByte cb, Document document, float pageWidth) throws Exception 
	    {
	    	float headerHeight = 25; // Altura deseada del rectángulo del encabezado

            // Rutas de las imágenes
            String imgPath1 = components_web_controller.getProperty("ASSETS_TIP_LOGO1");
            String imgPath2 = components_web_controller.getProperty("ASSETS_TIP_LOGO2");
            String imgPath3 = "";
            String imgPath4 = components_web_controller.getProperty("ASSETS_TIP_CUADRO1");
            String imgPath5 = components_web_controller.getProperty("ASSETS_TIP_CUADRO2");
            String imgPath6 = components_web_controller.getProperty("ASSETS_TIP_CUADRO3");
            String imgPath7 = components_web_controller.getProperty("ASSETS_TIP_CUADRO4");
            
            if(colorOption == 1)
            {   
            	imgPath3 = components_web_controller.getProperty("ASSETS_TIP_TEMA1");
            }
            else if(colorOption == 2)
            {	
            	imgPath3 = components_web_controller.getProperty("ASSETS_TIP_TEMA2");
            }
            else if(colorOption == 3)
            { 
            	imgPath3 = components_web_controller.getProperty("ASSETS_TIP_TEMA3");
            }
            else if(colorOption == 4)
            { 
            	imgPath3 = components_web_controller.getProperty("ASSETS_TIP_TEMA4");
            }
            else
            {
            	imgPath3 = components_web_controller.getProperty("ASSETS_TIP_TEMA1");
            }
            
	    	try 
	    	{	    			           	        
	            // Crear las instancias de las imágenes
	            Image img1 = Image.getInstance(imgPath1);
	            Image img2 = Image.getInstance(imgPath2);
	            Image img3 = Image.getInstance(imgPath3);
	            Image img4 = Image.getInstance(imgPath4);
	            Image img5 = Image.getInstance(imgPath5);
	            Image img6 = Image.getInstance(imgPath6);
	            Image img7 = Image.getInstance(imgPath7);

	            // Escalar las imágenes para que se ajusten al encabezado y los cuadros
	            img1.scalePercent(3);
	            img2.scalePercent(15);
	            img3.scaleToFit(220, 220);
	            img4.scaleToFit(120, 120);
	            img5.scaleToFit(120, 120);
	            img6.scaleToFit(120, 120);
	            img7.scaleToFit(120, 120);
	            
	            // Mantener las posiciones actuales de las imágenes 1, 2 y 3
	            float imgWidth1 = img1.getScaledWidth();
	            float imgWidth2 = img2.getScaledWidth();

	            float imgX1 = pageWidth - document.rightMargin() - imgWidth1 + 30; // Ajustar aquí para mover más hacia la derecha
	            float imgX2 = imgX1 - imgWidth2 - 5; // Ajustar aquí para mover más hacia la derecha

	            float imgY = document.top() - headerHeight + (headerHeight - img1.getScaledHeight()) / 2; // Centrar verticalmente

	            img1.setAbsolutePosition(imgX1, imgY-10);
	            img2.setAbsolutePosition(imgX2, imgY);

	            cb.addImage(img1);
	            cb.addImage(img2);

	            // Coordenadas del cuadrado grande
	            float squareSize = 250;
	            float squareX = (pageWidth - squareSize) / 2;
	            float squareY = document.top() - headerHeight - squareSize - 160;

	            // Calcular las coordenadas para centrar la imagen dentro del cuadrado grande
	            float img3X = squareX + (squareSize - img3.getScaledWidth()) / 2 - 135;
	            float img3Y = squareY + (squareSize - img3.getScaledHeight()) / 2;

	            // Posicionar la imagen dentro del cuadrado grande
	            img3.setAbsolutePosition(img3X, img3Y);
	            cb.addImage(img3);

	            // Coordenadas de las imágenes en los cuadros pequeños
	            float img4X = 37.63983f;
	            float img4Y = 246.0f;
	            img4.setAbsolutePosition(img4X, img4Y);
	            cb.addImage(img4);

	            float img5X = 37.63983f;
	            float img5Y = 116.0f;
	            img5.setAbsolutePosition(img5X, img5Y);
	            cb.addImage(img5);

	            float img6X = 165.63984f;
	            float img6Y = 246.0f;
	            img6.setAbsolutePosition(img6X, img6Y);
	            cb.addImage(img6);

	            float img7X = 165.63984f;
	            float img7Y = 116.0f;
	            img7.setAbsolutePosition(img7X, img7Y);
	            cb.addImage(img7);
                
	        } catch (IOException | DocumentException e) {
	            System.out.println("1. "+imgPath1);System.out.println("2. "+imgPath2);
	            System.out.println("3. "+imgPath3);System.out.println("4. "+imgPath4);
	            System.out.println("5. "+imgPath5);System.out.println("6. "+imgPath6);
	            System.out.println("7. "+imgPath7);
	            System.out.println("Error al cargar imágenes: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    private void drawFooter(PdfContentByte cb, Document document, float pageWidth) {
	    	cb.setColorFill(headerFooterColor); // Utilizar el color dinámico para el encabezado
	        cb.rectangle(0, 0, pageWidth, 60); // Dibujar fondo para pie de página
	        cb.fill();

	        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, footer, (pageWidth) / 2, document.bottom() - 10, 0);
	    }

	    private void drawAdditionalElements(PdfContentByte cb, Document document) 
	    {
	    	// Colores y configuraciones iniciales
	        cb.setColorFill(BaseColor.BLACK);
	        float headerHeight = 200; // Tamaño del rectángulo del encabezado
	        float footerHeight = 60; // Tamaño del rectángulo del pie de página
	        float squareSize = 250; // Tamaño de los cuadrados grandes
	        float spaceBetweenSquares = 7; // Espacio entre los cuadrados
	        float smallSquareSize = (squareSize - spaceBetweenSquares) / 2; // Tamaño de los cuadrados pequeños
	        float pageWidth = document.getPageSize().getWidth();
	        float pageHeight = document.getPageSize().getHeight();
	        float leftMargin = document.leftMargin();
	        float bottomMargin = document.bottomMargin();
	        float spaceToMoveDown = 100; // Espacio adicional para mover los cuadrados hacia abajo
	        
	        Font HEADER_FONT = new Font(Font.FontFamily.UNDEFINED, 20, Font.BOLD, GREEN);
		    Font TEXT_FONT    = new Font(Font.FontFamily.UNDEFINED, 10, Font.NORMAL, GREEN_LIGTH);

	        // Centrar verticalmente los cuadrados grandes
	        float centerY = (pageHeight - headerHeight - footerHeight - squareSize - spaceBetweenSquares) / 2 + footerHeight - spaceToMoveDown;

	        // Dibujar el primer cuadrado grande en el lado izquierdo
	        cb.setColorFill(largeSquareColor);
	        cb.rectangle(leftMargin, centerY + spaceBetweenSquares + squareSize, squareSize, squareSize); // Primer cuadrado grande
	        cb.fill();

	        // Ajustar la posición de los cuadrados pequeños para separarlos del cuadrado grande
	        float separation = 14; // Espacio adicional para separar el cuadrado grande de los pequeños
	        float smallSquareStartY = centerY + spaceBetweenSquares - separation;
	        float smallSquareStartX = leftMargin;

	        // Dibujar los cuatro cuadrados pequeños con diferentes colores
	        cb.setColorFill(GREEN_LIGTH);
	        cb.rectangle(smallSquareStartX, smallSquareStartY + smallSquareSize + spaceBetweenSquares, smallSquareSize, smallSquareSize); // Primer cuadrado pequeño
	        cb.fill();

	        cb.setColorFill(BLUE);
	        cb.rectangle(smallSquareStartX, smallSquareStartY, smallSquareSize, smallSquareSize); // Segundo cuadrado pequeño
	        cb.fill();

	        cb.setColorFill(ORANGE);
	        cb.rectangle(smallSquareStartX + smallSquareSize + spaceBetweenSquares, smallSquareStartY + smallSquareSize + spaceBetweenSquares, smallSquareSize, smallSquareSize); // Tercer cuadrado pequeño
	        cb.fill();

	        cb.setColorFill(YELLOW);
	        cb.rectangle(smallSquareStartX + smallSquareSize + spaceBetweenSquares, smallSquareStartY, smallSquareSize, smallSquareSize); // Cuarto cuadrado pequeño
	        cb.fill();

	        // Centrar párrafos en el lado derecho
	        try {
	        	// Párrafos
	            Phrase paragraph1 = new Phrase(tittle, HEADER_FONT);
	            Phrase paragraph2 = new Phrase(subtittle, HEADER_FONT);
	            Phrase paragraph3 = new Phrase(text, TEXT_FONT);
	            
	            // Ajustes para centrar verticalmente
	            float rightColumnWidth = pageWidth - leftMargin * 2 - squareSize - spaceBetweenSquares;
	            float rightColumnStartX = leftMargin + squareSize + spaceBetweenSquares;

	            // Calcular las posiciones verticales de los párrafos
	            float totalParagraphsHeight = paragraph1.getFont().getSize() + paragraph2.getFont().getSize() + paragraph3.getFont().getSize();
	            float availableSpace = squareSize - totalParagraphsHeight;

	            // Ajustar centerY para subir los textos
	            float verticalAdjustment = 150; // Ajuste vertical hacia arriba
	            centerY += verticalAdjustment;

	            float paragraph1Y = centerY + squareSize / 2 + paragraph3.getFont().getSize();
	            float paragraph2Y = paragraph1Y - paragraph2.getFont().getSize() - paragraph3.getFont().getSize();
	            float paragraph3Y = paragraph2Y - paragraph3.getFont().getSize() - 70; // Bajar el párrafo 3 unas unidades más

	            // Mostrar los párrafos centrados horizontalmente
	            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, paragraph1, rightColumnStartX + rightColumnWidth / 2, paragraph1Y, 0);
	            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, paragraph2, rightColumnStartX + rightColumnWidth / 2, paragraph2Y, 0);

	            // Crear un ColumnText para ajustar el párrafo 3 dentro de un área específica
	            ColumnText ct = new ColumnText(cb);
	            ct.setSimpleColumn(new Phrase(paragraph3), rightColumnStartX, paragraph3Y - 60, rightColumnStartX + rightColumnWidth, paragraph3Y + 40, 10, Element.ALIGN_CENTER);
	            ct.go();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	}	
	
	public static void convertPDFToImage(String pdfFilePath, String outputFilePath) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(pdfFilePath);
        int pageNum = reader.getNumberOfPages();
        for (int i = 1; i <= pageNum; i++) {
            BufferedImage image = renderPageToImage(reader, i);
            ImageIO.write(image, "png", new File(outputFilePath.replace(".png", "_" + i + ".png")));
        }
    }

    public static BufferedImage renderPageToImage(PdfReader reader, int pageNumber) throws IOException, DocumentException {
        // Get the page size
        com.itextpdf.text.Rectangle rect = reader.getPageSize(pageNumber);

        int width = (int) rect.getWidth();
        int height = (int) rect.getHeight();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setBackground(Color.WHITE);
        graphics.clearRect(0, 0, width, height);

        // Apply the affine transform to the graphics object
        AffineTransform at = new AffineTransform();
        at.scale(1, -1);
        at.translate(0, -height);
        graphics.setTransform(at);

        PdfContentByte content = new PdfContentByte(null);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);

        parser.processContent(pageNumber, new MyRenderListener(graphics));

        graphics.dispose();

        return bufferedImage;
    }

    private static class MyRenderListener implements RenderListener {
        private Graphics2D graphics;

        public MyRenderListener(Graphics2D graphics) {
            this.graphics = graphics;
        }

        @Override
        public void beginTextBlock() {
        }

        @Override
        public void renderText(TextRenderInfo renderInfo) {
            String text = renderInfo.getText();
            Rectangle2D.Float rect = renderInfo.getDescentLine().getBoundingRectange();

            // Apply necessary transformations and draw text
            graphics.drawString(text, (float) rect.getX(), (float) rect.getY());
        }

        @Override
        public void endTextBlock() {
        }

        @Override
        public void renderImage(ImageRenderInfo renderInfo) {
            try {
                PdfImageObject image = renderInfo.getImage();
                BufferedImage awtImage = image.getBufferedImage();
                if (awtImage == null) return;

                com.itextpdf.text.pdf.parser.Matrix matrix = renderInfo.getImageCTM();
                
                // Convertir Matrix a AffineTransform manualmente
                AffineTransform affineTransform = new AffineTransform(matrix.get(0), matrix.get(1), matrix.get(2), matrix.get(3), matrix.get(4), matrix.get(5));

                affineTransform.scale(1, -1); // Ajuste para la inversión en Y
                affineTransform.translate(0, -awtImage.getHeight());

                // Dibujar la imagen usando la AffineTransform
                Graphics2D graphics = (Graphics2D) this.graphics.create();
                graphics.drawImage(awtImage, affineTransform, null);
                graphics.dispose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

