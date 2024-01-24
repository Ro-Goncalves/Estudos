
function LoginPage() {

    async function loginAction(formData: FormData) {
        'use server';
        console.log("Login server")
        console.log(formData)
    }

    return (<div className="m-2">
        <div className="bg-white p-8 rounded shadow w-96">
            <h2 className="text-2xl mb-4 text-black">Login</h2>
            <form action={loginAction}>
                <div>
                    <label className="block text-sm text-gray-00">Usuário</label>
                    <input type="text" name="username" className="w-full p-2 border rounded shadow mt-1 text-black" />
                </div>
                <div>
                    <label className="block text-sm text-gray-00">Senha</label>
                    <input type="password" name="password" className="w-full p-2 border rounded shadow mt-1 text-black" />
                </div>
                <div><button type="submit" className="bg-blue-500 text-white p2 rounded w-full mt-4">Entrar</button></div>
            </form>
        </div>
    </div>)
}

export default LoginPage