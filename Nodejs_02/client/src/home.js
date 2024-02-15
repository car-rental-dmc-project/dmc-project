import {useHistory} from 'react-router-dom'
function Home() {
    const history =  useHistory();

    const Navigate = ()=>{
        history.push('/contact');
    }
    return ( <>
                <h1>Welcome home</h1>
                <button onClick={Navigate}>Click Me To Go To Contact Page</button>
             </> );
}

export default Home;