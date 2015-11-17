package org.cdlflex.sri.test;

import org.cdlflex.sri.EcoreToOWL;
import org.cdlflex.sri.TransformationException;
import org.junit.Test;

public class OneWayTest {

	@Test
	public void tboxTest() throws TransformationException {
		EcoreToOWL transformer = new EcoreToOWL();
		transformer.convertEcore2OWL("testinput/CAEX.ecore", "testoutput/caex.owl");
	}

	@Test
	public void aboxTest() throws TransformationException {
		EcoreToOWL transformer = new EcoreToOWL();
		transformer.convertEcore2OWLInclusiveInstances("testinput/CAEX.ecore", "testinput/AML_Erweitert.xmi", "testoutput/caex-instances.owl");
	}

}
