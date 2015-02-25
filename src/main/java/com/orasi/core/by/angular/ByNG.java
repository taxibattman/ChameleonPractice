package com.orasi.core.by.angular;
/*
Copyright 2007-2011 Selenium committers

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */


import java.io.Serializable;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByXPath;

/**
 * Mechanism used to locate elements within a document. In order to create your own locating
 * mechanisms, it is possible to subclass this class and override the protected methods as required,
 * though it is expected that that all subclasses rely on the basic finding mechanisms provided
 * through static methods of this class:
 * 
 * <code>
 * public WebElement findElement(WebDriver driver) {
 *     WebElement element = driver.findElement(By.id(getSelector()));
 *     if (element == null)
 *       element = driver.findElement(By.name(getSelector());
 *     return element;
 * }
 * </code>
 */
public abstract class ByNG {
  /**
   * @param id The value of the "id" attribute to search for
   * @return a By which locates elements by the value of the "id" attribute.
   *//*
  public static ByNG id(final String id) {
    if (id == null)
      throw new IllegalArgumentException(
          "Cannot find elements with a null id attribute.");

    return new ById(id);
  }

  *//**
   * @param linkText The exact text to match against
   * @return a By which locates A elements by the exact text it displays
   *//*
  public static ByNG linkText(final String linkText) {
    if (linkText == null)
      throw new IllegalArgumentException(
          "Cannot find elements when link text is null.");

    return new ByLinkText(linkText);
  }

  *//**
   * @param linkText The text to match against
   * @return a By which locates A elements that contain the given link text
   *//*
  public static ByNG partialLinkText(final String linkText) {
   if (linkText == null)
      throw new IllegalArgumentException(
          "Cannot find elements when link text is null.");

    return new ByPartialLinkText(linkText);
  }

  *//**
   * @param name The value of the "name" attribute to search for
   * @return a By which locates elements by the value of the "name" attribute.
   *//*
 public static ByNG name(final String name) {
   if (name == null)
      throw new IllegalArgumentException(
          "Cannot find elements when name text is null.");

    return new ByName(name);
  }*/

  /**
   * @param ngRepeater The value of the "ngButtonText" attribute to search for
   * @return a By which locates elements by the value of the "ngButtonText" attribute.
   */
  public static ByNG ngButtonText(final String ngButtonText) {
    if (ngButtonText == null)
      throw new IllegalArgumentException(
          "Cannot find elements when ngRepeater text is null.");

    return new ByNGButton(ngButtonText);
  }
  
  /**
   * @param ngController The value of the "ngController" attribute to search for
   * @return a By which locates elements by the value of the "ngController" attribute.
   */
  public static ByNG ngController(final String ngController) {
  /* @param ngRepeater The value of the "ngRepeater" attribute to search for
   * @return a By which locates elements by the value of the "ngRepeater" attribute.
   */
    if (ngController == null)
      throw new IllegalArgumentException(
          "Cannot find elements when ngRepeater text is null.");

    return new ByNGController(ngController);
  } 
  
  /**
   * @param ngModel The value of the "ngModel" attribute to search for
   * @return a By which locates elements by the value of the "ngModel" attribute.
   */
  public static ByNG ngModel(final String ngModel) {
  /* @param ngRepeater The value of the "ngRepeater" attribute to search for
   * @return a By which locates elements by the value of the "ngRepeater" attribute.
   */
    if (ngModel == null)
      throw new IllegalArgumentException(
          "Cannot find elements when ngRepeater text is null.");

    return new ByNGModel(ngModel);
  }
  
  /**
   * @param ngRepeater The value of the "ngRepeater" attribute to search for
   * @return a By which locates elements by the value of the "ngRepeater" attribute.
   */
 public static ByNG ngRepeater(final String ngRepeater) {
    if (ngRepeater == null)
      throw new IllegalArgumentException(
          "Cannot find elements when ngRepeater text is null.");

    return new ByNGRepeater(ngRepeater);
  }
/*
  *//**
   * @param name The element's tagName
   * @return a By which locates elements by their tag name
   *//*
  public static ByNG tagName(final String name) {
    if (name == null)
      throw new IllegalArgumentException(
          "Cannot find elements when name tag name is null.");

    return new ByTagName(name);
  }

  *//**
   * @param xpathExpression The xpath to use
   * @return a By which locates elements via XPath
   *//*
  public static ByNG xpath(final String xpathExpression) {
    if (xpathExpression == null)
      throw new IllegalArgumentException(
          "Cannot find elements when the XPath expression is null.");

    return new ByXPath(xpathExpression);
  }

  *//**
   * Finds elements based on the value of the "class" attribute. If an element has many classes then
   * this will match against each of them. For example if the value is "one two onone", then the
   * following "className"s will match: "one" and "two"
   * 
   * @param className The value of the "class" attribute to search for
   * @return a By which locates elements by the value of the "class" attribute.
   *//*
  public static ByNG className(final String className) {
    if (className == null)
      throw new IllegalArgumentException(
          "Cannot find elements when the class name expression is null.");

    return new ByClassName(className);
  }

  *//**
   * Finds elements via the driver's underlying W3 Selector engine. If the browser does not
   * implement the Selector API, a best effort is made to emulate the API. In this case, we strive
   * for at least CSS2 support, but offer no guarantees.
   *//*
  public static ByNG cssSelector(final String selector) {
    if (selector == null)
      throw new IllegalArgumentException(
          "Cannot find elements when the selector is null");

    return new ByCssSelector(selector);

  }
*/
  /**
   * Find a single element. Override this method if necessary.
   * 
   * @param context A context to use to find the element
   * @return The WebElement that matches the selector
   */
  public WebElement findElement(SearchContext context) {
    List<WebElement> allElements = findElements(context);
    if (allElements == null || allElements.isEmpty())
      throw new NoSuchElementException("Cannot locate an element using "
          + toString());
    return allElements.get(0);
  }

  /**
   * Find many elements.
   * 
   * @param context A context to use to find the element
   * @return A list of WebElements matching the selector
   */
  public abstract List<WebElement> findElements(SearchContext context);

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    ByNG byNG = (ByNG) o;

    return toString().equals(byNG.toString());
  }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }

  @Override
  public String toString() {
    // A stub to prevent endless recursion in hashCode()
    return "[unknown locator]";
  }
/*
  public static class ById extends ByNG implements Serializable {
    private static final long serialVersionUID = 5341968046120372169L;

    private final String id;

    public ById(String id) {
      this.id = id;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
      if (context instanceof FindsById)
        return ((FindsById) context).findElementsById(id);
      return ((FindsByXPath) context).findElementsByXPath(".//*[@id = '" + id
          + "']");
    }

    @Override
    public WebElement findElement(SearchContext context) {
      if (context instanceof FindsById)
        return ((FindsById) context).findElementById(id);
      return ((FindsByXPath) context).findElementByXPath(".//*[@id = '" + id
          + "']");
    }

    @Override
    public String toString() {
      return "By.id: " + id;
    }
  }

  public static class ByLinkText extends ByNG implements Serializable {
    private static final long serialVersionUID = 1967414585359739708L;

    private final String linkText;

    public ByLinkText(String linkText) {
      this.linkText = linkText;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
      return ((FindsByLinkText) context).findElementsByLinkText(linkText);
    }

    @Override
    public WebElement findElement(SearchContext context) {
      return ((FindsByLinkText) context).findElementByLinkText(linkText);
    }

    @Override
    public String toString() {
      return "By.linkText: " + linkText;
    }
  }

  public static class ByPartialLinkText extends ByNG implements Serializable {
    private static final long serialVersionUID = 1163955344140679054L;

    private final String linkText;

    public ByPartialLinkText(String linkText) {
      this.linkText = linkText;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
      return ((FindsByLinkText) context)
          .findElementsByPartialLinkText(linkText);
    }

    @Override
    public WebElement findElement(SearchContext context) {
      return ((FindsByLinkText) context).findElementByPartialLinkText(linkText);
    }

    @Override
    public String toString() {
      return "By.partialLinkText: " + linkText;
    }
  }

  public static class ByName extends ByNG implements Serializable {
    private static final long serialVersionUID = 376317282960469555L;

    private final String name;

    public ByName(String name) {
      this.name = name;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
      if (context instanceof FindsByName)
        return ((FindsByName) context).findElementsByName(name);
      return ((FindsByXPath) context).findElementsByXPath(".//*[@name = '"
          + name + "']");
    }

    @Override
    public WebElement findElement(SearchContext context) {
      if (context instanceof FindsByName)
        return ((FindsByName) context).findElementByName(name);
      return ((FindsByXPath) context).findElementByXPath(".//*[@name = '"
          + name + "']");
    }

    @Override
    public String toString() {
      return "By.name: " + name;
    }
  }*/

  public static class ByNGButton extends ByNG implements Serializable {

	    private static final long serialVersionUID = 376317282960469555L;

	    private final String name;

	    public ByNGButton(String name) {
	      this.name = name;
	    }

	    @Override
	    public List<WebElement> findElements(SearchContext context) {
	      if (context instanceof FindsByNGButtonText)
	        return ((FindsByNGButtonText) context).findElementsByNGButton(name);
	      return ((FindsByXPath) context).findElementsByXPath(".//*[@name = '"
	          + name + "']");
	    }

	    @Override
	    public WebElement findElement(SearchContext context) {
	      if (context instanceof FindsByNGButtonText)
	        return ((FindsByNGButtonText) context).findElementByNGButton(name);
	      return (WebElement) ((FindsByXPath) context).findElementsByXPath(".//*[@name = '"
	          + name + "']");
	    }

	    @Override
	    public String toString() {
	      return "By.name: " + name;
	    }
	  }
  
  public static class ByNGModel extends ByNG implements Serializable {

    private static final long serialVersionUID = 376317282960469555L;

    private final String name;

    public ByNGModel(String name) {
      this.name = name;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
      if (context instanceof FindsByNGModel)
        return ((FindsByNGModel) context).findElementsByNGModel(name);
      return ((FindsByXPath) context).findElementsByXPath(".//*[@name = '"
          + name + "']");
    }

    @Override
    public WebElement findElement(SearchContext context) {
      if (context instanceof FindsByNGModel)
        return ((FindsByNGModel) context).findElementByNGModel(name);
      return (WebElement) ((FindsByXPath) context).findElementsByXPath(".//*[@name = '"
          + name + "']");
    }

    @Override
    public String toString() {
      return "By.name: " + name;
    }
  }
  
  public static class ByNGController extends ByNG implements Serializable {

	    private static final long serialVersionUID = 376317282960469555L;

	    private final String name;

	    public ByNGController(String name) {
	      this.name = name;
	    }

	    @Override
	    public List<WebElement> findElements(SearchContext context) {
	      if (context instanceof FindsByNGContoller)
	        return ((FindsByNGContoller) context).findElementsByNGContoller(name);
	      return ((FindsByXPath) context).findElementsByXPath(".//*[@name = '"
	          + name + "']");
	    }

	    @Override
	    public WebElement findElement(SearchContext context) {
	      if (context instanceof FindsByNGContoller)
	        return ((FindsByNGContoller) context).findElementByNGContoller(name);
	      return (WebElement) ((FindsByXPath) context).findElementsByXPath(".//*[@name = '"
	          + name + "']");
	    }

	    @Override
	    public String toString() {
	      return "By.name: " + name;
	    }
	  }
  
  public static class ByNGRepeater extends ByNG implements Serializable {
    private static final long serialVersionUID = 376317282960469555L;

    private final String name;

    public ByNGRepeater(String name) {
      this.name = name;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
      if (context instanceof FindsByNGRepeat)
        return ((FindsByNGRepeat) context).findElementsByNGRepeat(name);
      return ((FindsByXPath) context).findElementsByXPath(".//*[@name = '"
          + name + "']");
    }

    @Override
    public WebElement findElement(SearchContext context) {
      if (context instanceof FindsByNGRepeat)
        return ((FindsByNGRepeat) context).findElementByNGRepeat(name);
      return (WebElement) ((FindsByXPath) context).findElementsByXPath(".//*[@name = '"
          + name + "']");
    }

    @Override
    public String toString() {
      return "By.name: " + name;
    }
  }
  /*
  public static class ByTagName extends ByNG implements Serializable {
    private static final long serialVersionUID = 4699295846984948351L;

    private final String name;

    public ByTagName(String name) {
      this.name = name;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
      if (context instanceof FindsByTagName)
        return ((FindsByTagName) context).findElementsByTagName(name);
      return ((FindsByXPath) context).findElementsByXPath(".//" + name);
    }

    @Override
    public WebElement findElement(SearchContext context) {
      if (context instanceof FindsByTagName)
        return ((FindsByTagName) context).findElementByTagName(name);
      return ((FindsByXPath) context).findElementByXPath(".//" + name);
    }

    @Override
    public String toString() {
      return "By.tagName: " + name;
    }
  }

  public static class ByXPath extends ByNG implements Serializable {

    private static final long serialVersionUID = -6727228887685051584L;

    private final String xpathExpression;

    public ByXPath(String xpathExpression) {
      this.xpathExpression = xpathExpression;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
      return ((FindsByXPath) context).findElementsByXPath(xpathExpression);
    }

    @Override
    public WebElement findElement(SearchContext context) {
      return ((FindsByXPath) context).findElementByXPath(xpathExpression);
    }

    @Override
    public String toString() {
      return "By.xpath: " + xpathExpression;
    }
  }

  public static class ByClassName extends ByNG implements Serializable {

    private static final long serialVersionUID = -8737882849130394673L;

    private final String className;

    public ByClassName(String className) {
      this.className = className;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
      if (context instanceof FindsByClassName)
        return ((FindsByClassName) context).findElementsByClassName(className);
      return ((FindsByXPath) context).findElementsByXPath(".//*["
          + containingWord("class", className) + "]");
    }

    @Override
    public WebElement findElement(SearchContext context) {
      if (context instanceof FindsByClassName)
        return ((FindsByClassName) context).findElementByClassName(className);
      return ((FindsByXPath) context).findElementByXPath(".//*["
          + containingWord("class", className) + "]");
    }

    *//**
     * Generates a partial xpath expression that matches an element whose specified attribute
     * contains the given CSS word. So to match &lt;div class='foo bar'&gt; you would say "//div[" +
     * containingWord("class", "foo") + "]".
     * 
     * @param attribute name
     * @param word name
     * @return XPath fragment
     *//*
    private String containingWord(String attribute, String word) {
      return "contains(concat(' ',normalize-space(@" + attribute + "),' '),' "
          + word + " ')";
    }

    @Override
    public String toString() {
      return "By.className: " + className;
    }
  }

  public static class ByCssSelector extends ByNG implements Serializable {

    private static final long serialVersionUID = -3910258723099459239L;

    private final String selector;

    public ByCssSelector(String selector) {
      this.selector = selector;
    }

    @Override
    public WebElement findElement(SearchContext context) {
      if (context instanceof FindsByCssSelector) {
        return ((FindsByCssSelector) context)
            .findElementByCssSelector(selector);
      }

      throw new WebDriverException(
          "Driver does not support finding an element by selector: " + selector);
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
      if (context instanceof FindsByCssSelector) {
        return ((FindsByCssSelector) context)
            .findElementsByCssSelector(selector);
      }

      throw new WebDriverException(
          "Driver does not support finding elements by selector: " + selector);
    }

    @Override
    public String toString() {
      return "By.selector: " + selector;
    }
  }*/
}