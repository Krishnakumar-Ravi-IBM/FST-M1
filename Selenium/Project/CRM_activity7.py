from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC, expected_conditions

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # initialize the wait object
    wait = WebDriverWait(driver, 10)

    # Navigate to the URL
    driver.get("http://alchemy.hguy.co/crm")
    # Print the title of the page
    print("Page title is: ", driver.title)

    txtUname = driver.find_element(By.ID, "user_name")
    txtPwd = driver.find_element(By.ID, "username_password")
    btnLogin = driver.find_element(By.ID, "bigbutton")
    txtUname.send_keys("admin")
    txtPwd.send_keys("pa$$w0rd")
    btnLogin.click()

    pgeHome = driver.title
    print("The homePage title is: " + pgeHome)
    assert pgeHome == "SuiteCRM"

    sales = driver.findElement(By.ID, "grouptab_0")
    waitEle1 = driver.find_element(By.XPATH, "//span[normalize-space()='My Open Cases']")
    wait.until(expected_conditions.visibility_of_element_located(waitEle1))

    # Set up the actions object
    actions = webdriver.ActionChains(driver)
    actions.move_to_element(sales).perform()

    leads = driver.findElement(By.ID, "moduleTab_9_Leads")
    wait.until(expected_conditions.visibility_of(leads))
    actions.move_to_element(leads).click().perform()

    print("*********** Navigating to Leads module *********")
    waitEle2 = driver.find_element(By.XPATH, "//h2[@class='module-title-text']")
    wait.until(expected_conditions.visibility_of_element_located(waitEle2))

    ele = driver.findElement(By.XPATH, "//tr[2]/td[10]")
    wait.until(expected_conditions.visibility_of(ele))
    ele.click()
    waitEle3 = driver.find_element(By.XPATH, "//div[normalize-space()='Additional Details']")
    wait.until(expected_conditions.visibility_of_element_located(waitEle3))
    phone = driver.findElement(By.XPATH, "//span[@class='phone']")
    strPhone = phone.getText()

    print("The Phone number displayed in the pop up is: "+strPhone)

    print("Run Completed")

    # close the browser
    driver.quit()
