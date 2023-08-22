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
    wait.until(expected_conditions.visibility_of_element_located(By.XPATH, "//span[normalize-space()='My Open Cases']"))

    # Set up the actions object
    actions = webdriver.ActionChains(driver)
    actions.move_to_element(sales).perform()

    leads = driver.findElement(By.ID, "moduleTab_9_Leads")
    wait.until(expected_conditions.visibility_of(leads))
    actions.move_to_element(leads).click().perform()

    print("*********** Navigating to Leads module *********")

    wait.until(expected_conditions.visibility_of_element_located(By.XPATH, "//h2[@class='module-title-text']"))

    for x in range(1,11):
        name = driver.findElement(By.XPATH, "//table[contains(@class,'responsive')]/tbody/tr[" + x + "]/td[3]").getText())
        user = driver.findElement(By.XPATH, "//table[contains(@class,'responsive')]/tbody/tr[" + x + "]/td[8]").getText())
        print("Name displayed in Row number " + x + " is: " + name + " and respective User ID is: " + user)

    print("Run Completed")

    # close the browser
    driver.quit()
