package com.P5.xml;

import com.P5.entities.Delegacion;
import com.P5.entities.Proyecto;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class XMLManager {
    Document doc;

    public XMLManager() throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File("db.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        this.doc = dBuilder.parse(inputFile);
        this.doc.getDocumentElement().normalize();
    }

    public NodeList recuperarElemento(String elementTagName) {
        return this.doc.getElementsByTagName(elementTagName);
    }

    public Node recuperarElementoEnElemento(String elementTagName, Node element) {
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeName().equals(elementTagName)) {
                return childNodes.item(i);
            }
        }

        return null;
    }

    public Element crearElementoDelegacion(Delegacion delegacion) {
        Element delegacionXML = this.doc.createElement("delegacion");

        delegacionXML.setAttribute("id", delegacion.getId().toString());

        Element ciudad = this.doc.createElement("ciudad");
        ciudad.appendChild(this.doc.createTextNode(delegacion.getCiudad()));
        delegacionXML.appendChild(ciudad);

        Element direccion = this.doc.createElement("direccion");
        direccion.appendChild(this.doc.createTextNode(delegacion.getDireccion()));
        delegacionXML.appendChild(direccion);

        Element telefono = this.doc.createElement("telefono");
        telefono.appendChild(this.doc.createTextNode(delegacion.getTelefono()));
        delegacionXML.appendChild(telefono);

        Element email = this.doc.createElement("email");
        email.appendChild(this.doc.createTextNode(delegacion.getEmail()));
        delegacionXML.appendChild(email);

        Element central = this.doc.createElement("central");
        String centralStr = "";
        if (delegacion.getCentral()) {
            centralStr = "true";
        } else {
            centralStr = "false";
        }
        central.appendChild(this.doc.createTextNode(centralStr));
        delegacionXML.appendChild(central);

        return delegacionXML;
    }

    public Element crearElementoProyecto(Proyecto proyecto) {
        Element proyectoXML = this.doc.createElement("proyecto");
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");

        Element nombre = this.doc.createElement("nombre");
        nombre.appendChild(this.doc.createTextNode(proyecto.getNombre()));
        proyectoXML.appendChild(nombre);

        Element pais = this.doc.createElement("pais");
        pais.appendChild(this.doc.createTextNode(proyecto.getPais()));
        proyectoXML.appendChild(pais);

        Element localizacion = this.doc.createElement("localizacion");
        localizacion.appendChild(this.doc.createTextNode(proyecto.getLocalizacion()));
        proyectoXML.appendChild(localizacion);

        Element lineaAccion = this.doc.createElement("lineaAccion");
        lineaAccion.appendChild(this.doc.createTextNode(proyecto.getLineaAccion()));
        proyectoXML.appendChild(lineaAccion);

        Element subLineaAccion = this.doc.createElement("subLineaAccion");
        subLineaAccion.appendChild(this.doc.createTextNode(proyecto.getSubLineaAccion()));
        proyectoXML.appendChild(subLineaAccion);

        Element fechaInicio = this.doc.createElement("fechaInicio");
        fechaInicio.appendChild(this.doc.createTextNode(dateFormat.format(proyecto.getFechaInicio())));
        proyectoXML.appendChild(fechaInicio);

        Element fechaFin = this.doc.createElement("fechaFin");
        fechaFin.appendChild(this.doc.createTextNode(dateFormat.format(proyecto.getFechaFin())));
        proyectoXML.appendChild(fechaFin);

        Element socioLocal = this.doc.createElement("socioLocal");
        socioLocal.appendChild(this.doc.createTextNode(proyecto.getSocioLocal()));
        proyectoXML.appendChild(socioLocal);

        Element financiador = this.doc.createElement("financiador");
        financiador.appendChild(this.doc.createTextNode(proyecto.getFinanciador()));
        proyectoXML.appendChild(financiador);

        Element financiacionAportada = this.doc.createElement("financiacionAportada");
        financiacionAportada.appendChild(this.doc.createTextNode(proyecto.getFinanciacionAportada()));
        proyectoXML.appendChild(financiacionAportada);

        Element personalAsociado = this.doc.createElement("personalAsociado");
        for (int i = 0; i < proyecto.getPersonalAsociado().size(); i++) {
            Element personalId = this.doc.createElement("personal");
            personalId.appendChild(this.doc.createTextNode(Integer.toString(proyecto.getPersonalAsociado().get(i).getIdPersona())));
            personalAsociado.appendChild(personalId);
        }
        proyectoXML.appendChild(personalAsociado);

        Element delegacion = this.doc.createElement("delegacion");
        delegacion.appendChild(this.doc.createTextNode(proyecto.getDelegacion().getId().toString()));
        proyectoXML.appendChild(delegacion);

        return proyectoXML;
    }

    public void anhadirElemento(String parentName, Element element) throws TransformerException {
        Node parent = recuperarElemento(parentName).item(0);
        if (parent == null) {
            parent = this.doc.createElement(parentName);
        }
        parent.appendChild(element);
        this.doc.getDocumentElement().appendChild(parent);

        this.escribirDocumento();
    }

    public void eliminarElemento(String parentTagName, String elementTagName, String elementId) throws TransformerException {
        NodeList nodeList = this.doc.getElementsByTagName(elementTagName);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element delegacionXML = (Element) nodeList.item(i);
            if (delegacionXML.getAttribute("id").equals(elementId)) {
                this.doc.getElementsByTagName(parentTagName).item(0).removeChild(delegacionXML);
            }
        }

        this.escribirDocumento();
    }

    private void escribirDocumento() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(this.doc);
        StreamResult streamResult = new StreamResult(new File("db.xml"));
        transformer.transform(domSource, streamResult);
    }
}
