from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

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

    txtUname = driver.find_element(By.ID("user_name"))
    txtPwd = driver.find_element(By.ID("username_password"))
    btnLogin = driver.find_element(By.ID("bigbutton"))
    txtUname.send_keys("admin")
    txtPwd.send_keys("pa$$w0rd")
    btnLogin.click()
    pgeHome = driver.title
    print("The homePage title is: " + pgeHome)
    assert pgeHome == "SuiteCRM"
    print("Run Completed")

    # close the browser
    driver.quit()
